import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GeneratedPassword extends JFrame {

    private JLabel label;
    private JTextField password;
    private JPanel panel;

    public GeneratedPassword() {
        this.label = new JLabel("Generated password:");
        this.password = new JTextField(RandomGenerator.password);
        setPanel();
        action();
        this.setLayout(new BorderLayout());
        this.setSize(250, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.add(label, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.setResizable(false);
        //this.pack();
        this.setVisible(true);
    }

    public void setPanel(){
        this.panel = new JPanel(new BorderLayout());
        this.password.setEditable(false);
        this.password.setBorder(null);
        this.password.setBackground(null);
        this.password.setHorizontalAlignment(SwingConstants.CENTER);
        this.panel.add(password, BorderLayout.CENTER);
    }

    public void action(){
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }
        });
    }


}
