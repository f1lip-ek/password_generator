import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratedPassword extends JPanel {

    private final JLabel label;
    public JTextField password;
    public static JButton goBack;
    private final JButton copyToClipboard;
    private final JPanel panel;

    public GeneratedPassword() {
        this.panel = new JPanel();
        goBack =  new JButton("Go Back");
        this.label = new JLabel("Generated password:");
        this.password = new JTextField("act");
        copyToClipboard = new JButton("Copy to clipboard");
        setPanel();
        this.setLayout(new BorderLayout());
        this.setSize(250, 250);
        this.add(this.label, BorderLayout.NORTH);
        //this.add(goBack, BorderLayout.SOUTH);
        this.add(this.password, BorderLayout.CENTER);
        //this.add(copyToClipboard, BorderLayout.SOUTH);
        setButtons();
        //this.pack();
    }

    public void setPanel() {
        this.password.setText(RandomGenerator.password);
        this.password.setEditable(false);
        this.password.setBorder(null);
        this.password.setBackground(null);
        this.password.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setButtons(){
        setCopyButton();
        this.panel.setLayout(new GridLayout(2, 1));
        this.panel.add(copyToClipboard);
        this.panel.add(goBack);
        this.add(this.panel, BorderLayout.SOUTH);
    }

    public void setCopyButton(){
        copyToClipboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(RandomGenerator.password);

                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

                clipboard.setContents(stringSelection, null);
            }
        });
    }


}
