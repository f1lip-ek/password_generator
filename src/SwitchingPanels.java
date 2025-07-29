import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchingPanels extends JPanel {

    private FirstPanel firstPanel;
    private GeneratedPassword secondPanel;
    private CardLayout cardLayout;

    public SwitchingPanels() {
        this.firstPanel = new FirstPanel();
        this.secondPanel = new GeneratedPassword();
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.add(firstPanel, "Panel1");
        this.add(secondPanel, "Panel2");
        this.cardLayout.show(this, "Panel1");
        act();
    }

    public void act(){
        FirstPanel.generatePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!firstPanel.length.getText().isEmpty() && RandomGenerator.user.isSelected()){
                    RandomGenerator.user.setLength(Integer.parseInt(firstPanel.length.getText()));
                    RandomGenerator.user.setUpperCase(firstPanel.upperCase.isSelected());
                    RandomGenerator.user.setLowerCase(firstPanel.lowerCase.isSelected());
                    RandomGenerator.user.setNumbers(firstPanel.numbers.isSelected());
                    RandomGenerator.user.setSpecial(firstPanel.special.isSelected());
                    firstPanel.rg.generatePassword();
                    secondPanel.password.setText(RandomGenerator.password);

                    // Přepne na "Panel2" (GeneratedPassword) po stisku tlačítka
                    cardLayout.show(SwitchingPanels.this, "Panel2");
                }
            }
        });

        // Akce pro tlačítko "goBack" na druhém panelu
        GeneratedPassword.goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomGenerator.password = "";
                // Přepne zpět na "Panel1" (FirstPanel) po stisku tlačítka
                cardLayout.show(SwitchingPanels.this, "Panel1");
            }
        });
    }

}
