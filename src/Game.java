import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame{
    private JButton [][] buttons;
    private char currentplayer;
    private JLabel statuslabel;
    private JButton backButton;
    public Game(){
        setTitle("Tic-Tac-Toe");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel=new JPanel(new GridLayout(3,3));
        buttons =new JButton[3][3];

        //create and add buttons
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                buttons[i][j]=new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].addActionListener(new ButtonClickListener());
                panel.add(buttons[i][j]);
            }
        }

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backToMainMenu();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        statuslabel =new JLabel("X'turn");
        statuslabel.setFont(new Font("Arial",Font.PLAIN,20));
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(statuslabel, BorderLayout.NORTH);

        add(mainPanel);

        currentplayer = 'X';
        setVisible(true);

        Dimension screensize= Toolkit.getDefaultToolkit().getScreenSize();
        int centerX=(int)((screensize.getWidth()-getWidth())/2);
        int centerY=(int)((screensize.getHeight()-getHeight())/2);
        setLocation(centerX,centerY);
    }

    
    //Game reset
    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        currentplayer = 'X';
        statuslabel.setText("X's turn");
    }
    private void backToMainMenu() {
        new MainMenu();
        dispose();
    }
    //Game finish option
    private boolean showPlayAgainDialog(String message) {
        int option = JOptionPane.showConfirmDialog(this, message, "Game Over",JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
           return false;//hide dialog
        }
        return true;
    }
    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton buttonclicked=(JButton)e.getSource();
            if(buttonclicked.getText().equals("")){
                buttonclicked.setText(String.valueOf(currentplayer));
    
            if (checkWin()) {
                    statuslabel.setText(currentplayer + " wins!");
                    disableAllButtons();
                    showPlayAgainDialog(currentplayer + " wins! Do you want to play again?");// Call showPlayAgainDialog() method
                } else if (checkDraw()) {
                    statuslabel.setText("It's a draw!");
                    disableAllButtons();
                    showPlayAgainDialog("It's a draw! Do you want to play again?");// Call showPlayAgainDialog() method
                } else {
                    currentplayer = (currentplayer == 'X') ? 'O' : 'X';
                    statuslabel.setText(currentplayer + "'s turn");
                }
            }
        }
        // Win Condition check
        private boolean checkWin(){
            //check rows
            for(int i=0;i<3;i++){
                if(buttons[i][0].getText().equals(String.valueOf(currentplayer)) && buttons[i][1].getText().equals(String.valueOf(currentplayer))
                && buttons[i][2].getText().equals(String.valueOf(currentplayer))){
                    return true;
                }
            }
            //check columns
            for(int i=0;i<3;i++){
                if(buttons[0][i].getText().equals(String.valueOf(currentplayer)) && buttons[1][i].getText().equals(String.valueOf(currentplayer))
                && buttons[2][i].getText().equals(String.valueOf(currentplayer))){
                    return true;
                }
            }
            //check Diagonals
            for(int i=0;i<3;i++){
                if(buttons[0][0].getText().equals(String.valueOf(currentplayer)) && buttons[1][1].getText().equals(String.valueOf(currentplayer))
                && buttons[2][2].getText().equals(String.valueOf(currentplayer))){
                    return true;
                }
            }
            for(int i=0;i<3;i++){
                if(buttons[0][2].getText().equals(String.valueOf(currentplayer)) && buttons[1][1].getText().equals(String.valueOf(currentplayer))
                && buttons[2][0].getText().equals(String.valueOf(currentplayer))){
                    return true;
                }
            }
            return false;
        }
        //check Draw
        private boolean checkDraw(){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(buttons[i][j].getText().equals("")){
                        return false;
                    }
                }
            }
            return true;
        }
        
        private boolean disableAllButtons()
        {
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    buttons[i][j].setEnabled(false);
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        //new Game();
    }
}