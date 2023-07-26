import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    MainMenu()
    {
        setTitle("MainMenu");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel MenuPanel= new JPanel(new GridLayout(4,1,10,10));
        MenuPanel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));

        JLabel Title = new JLabel("Tic-Tac-Toe", SwingConstants.CENTER);
        Title.setFont(new Font("Times New Roman",Font.BOLD,30));
        MenuPanel.add(Title);

        JButton Multiplayerbutton =new JButton("Player Vs Player");
        JButton AIPlayerbutton =new JButton("Player Vs AI");

        Multiplayerbutton.setPreferredSize(new Dimension(120, 40));
        AIPlayerbutton.setPreferredSize(new Dimension(120, 40));

        MenuPanel.add(Multiplayerbutton);
        MenuPanel.add(AIPlayerbutton);

        Multiplayerbutton.addActionListener(new MultiplayerListener());
        AIPlayerbutton.addActionListener(new PlayerAIListener());

        add(MenuPanel,BorderLayout.CENTER);
        setVisible(true);

        Dimension screensize= Toolkit.getDefaultToolkit().getScreenSize();
        int centerX=(int)((screensize.getWidth()-getWidth())/2);
        int centerY=(int)((screensize.getHeight()-getHeight())/2);
        setLocation(centerX,centerY);
    }
    private class MultiplayerListener implements ActionListener{
        public void actionPerformed (ActionEvent a){
            new Game();
            dispose();
        }
    }
    private class PlayerAIListener implements ActionListener{
        public void actionPerformed (ActionEvent a)
        {
            new AIPlayer();
            dispose();
        }
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
