import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GeneratedPassword extends JPanel {

    private JLabel label;
    private JTextField password;
    private JPanel panel;
    public static JButton goBack;

    public GeneratedPassword() {
        goBack =  new JButton("Go Back");
        this.label = new JLabel("Generated password:");
        this.password = new JTextField(RandomGenerator.password);
        setPanel();
        action();
        this.setLayout(new BorderLayout());
        this.setSize(250, 250);
        this.add(label, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.add(goBack, BorderLayout.SOUTH);
        //this.pack();
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
