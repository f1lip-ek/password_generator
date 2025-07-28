import javax.swing.*;
import java.awt.*;

public class FirstPanel extends JPanel {

    private JButton generatePassword;
    private JCheckBox upperCase;
    private JCheckBox lowerCase;
    private JCheckBox numbers;
    private JCheckBox special;
    private JTextField length;
    private JPanel panel;
    private JPanel panel1;
    private JLabel napis;

    public FirstPanel() {
        this.napis = new JLabel("Password generator");
        this.generatePassword = new JButton("Generate password");
        this.upperCase = new JCheckBox("Upper case");
        this.lowerCase = new JCheckBox("Lower case");
        this.numbers = new JCheckBox("Numbers");
        this.special = new JCheckBox("Special characters");
        this.length = new JTextField("");
        this.setLayout(new BorderLayout());
        this.add(generatePassword, BorderLayout.SOUTH);
        setPanel();
        setPanel1();
    }

    public void setPanel(){
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(4, 1));
        this.panel.add(upperCase);
        this.panel.add(lowerCase);
        this.panel.add(numbers);
        this.panel.add(special);
        this.add(panel, BorderLayout.CENTER);
        generatePassword();
        setParameters();
        setDefault();
    }

    public void setPanel1(){
        this.panel1 = new JPanel();
        this.panel1.setLayout(new BorderLayout());
        this.panel1.add(napis, BorderLayout.NORTH);
        this.panel1.add(length, BorderLayout.SOUTH);
        this.add(panel1, BorderLayout.NORTH);
    }

    public void generatePassword() {
        this.generatePassword.addActionListener(e -> {
            if (!length.getText().isEmpty() && RandomGenerator.user.isSelected()){
                RandomGenerator.user.setLength(Integer.parseInt(length.getText()));
                RandomGenerator.user.setUpperCase(upperCase.isSelected());
                RandomGenerator.user.setLowerCase(lowerCase.isSelected());
                RandomGenerator.user.setNumbers(numbers.isSelected());
                RandomGenerator.user.setSpecial(special.isSelected());
                RandomGenerator rg = new RandomGenerator();
                rg.generatePassword();
                new GeneratedPassword();
            }
        });
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

}
