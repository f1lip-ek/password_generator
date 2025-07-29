import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FirstPanel extends JPanel {

    public static JButton generatePassword;
    public JCheckBox upperCase;
    public JCheckBox lowerCase;
    public JCheckBox numbers;
    public JCheckBox special;
    public JTextField length;
    private final JLabel napis;
    public RandomGenerator rg;

    public FirstPanel() {
        this.napis = new JLabel("Password generator");
        generatePassword = new JButton("Generate password");
        this.upperCase = new JCheckBox("Upper case");
        this.lowerCase = new JCheckBox("Lower case");
        this.numbers = new JCheckBox("Numbers");
        this.special = new JCheckBox("Special characters");
        this.length = new JTextField("");
        rg = new RandomGenerator();
        this.setLayout(new BorderLayout());
        this.add(generatePassword, BorderLayout.SOUTH);
        setPanel();
        setPanel1();
        rd();
    }

    public void setPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(upperCase);
        panel.add(lowerCase);
        panel.add(numbers);
        panel.add(special);
        this.add(panel, BorderLayout.CENTER);
        setParameters();
        setDefault();
    }

    public void setPanel1(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(napis, BorderLayout.NORTH);
        panel1.add(length, BorderLayout.SOUTH);
        this.add(panel1, BorderLayout.NORTH);
    }

    public void setParameters(){
        this.upperCase.addActionListener(e -> {
            if (upperCase.isSelected()) {
                RandomGenerator.user.setUpperCase(true);
            }
        });
        this.lowerCase.addActionListener(e -> {
            if (lowerCase.isSelected()) {
                RandomGenerator.user.setLowerCase(true);
            }
        });
        this.numbers.addActionListener(e -> {
            if (numbers.isSelected()) {
                RandomGenerator.user.setNumbers(true);
            }
        });
        this.special.addActionListener(e -> {
            if (special.isSelected()) {
                RandomGenerator.user.setSpecial(true);
            }
        });
    }

    public void setDefault(){
        this.upperCase.setSelected(true);
        this.lowerCase.setSelected(true);
        this.numbers.setSelected(true);
        this.special.setSelected(true);
    }

    public void rd(){
        this.length.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    generatePassword.doClick();
                }
            }
        });

    }
}
