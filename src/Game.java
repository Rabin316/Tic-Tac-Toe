import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame{
    private JButton [][] buttons;
    private char currentplayer;
    private JLabel statuslabel;
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
                buttons[i][j]=new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].addActionListener(new ButtonClickListener());
                panel.add(buttons[i][j]);
            }
        }

        statuslabel =new JLabel("X'turn");
        statuslabel.setFont(new Font("Arial",Font.PLAIN,20));
        add(panel, BorderLayout.CENTER);
        add(statuslabel, BorderLayout.SOUTH);
        currentplayer = 'X';
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

        }
    }
    public static void main(String[] args) {
        new Game();
    }
}