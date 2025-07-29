import javax.swing.*;
import java.awt.*;

public class GeneratedPassword extends JPanel {

    private JLabel label;
    public JTextField password;
    public static JButton goBack;

    public GeneratedPassword() {
        goBack =  new JButton("Go Back");
        this.label = new JLabel("Generated password:");
        this.password = new JTextField("gfjgfkjhg");
        setPanel();
        this.setLayout(new BorderLayout());
        this.setSize(250, 250);
        this.add(this.label, BorderLayout.NORTH);
        this.add(goBack, BorderLayout.SOUTH);
        this.add(this.password, BorderLayout.CENTER);
        //this.pack();
    }

    public void setPanel() {
        this.password.setText(RandomGenerator.password);
        this.password.setEditable(true);
        this.password.setBorder(null);
        this.password.setBackground(null);
        this.password.setHorizontalAlignment(SwingConstants.CENTER);
    }


}
