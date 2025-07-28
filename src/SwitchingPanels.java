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

//    public void act() {
//        new Thread(() -> {
//            while (true){
//                if (FirstPanel.generatePassword.isSelected()) {
//                    this.cardLayout.show(this, "Panel2");
//                } else if (GeneratedPassword.goBack.isSelected()) {
//                    this.cardLayout.show(this, "Panel1");
//                }
//                /*try {
//                    Thread.sleep(100); // Počkej 100 ms před další kontrolou
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt(); // Zpracování přerušení
//                    System.err.println("Thread interrupted: " + e.getMessage());
//                    break;
//                }*/
//            }
//        }).start();
//    }

    public void act(){
        firstPanel.generatePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Přepne na "Panel2" (GeneratedPassword) po stisku tlačítka
                cardLayout.show(SwitchingPanels.this, "Panel2"); // Použijeme SwitchingPanels.this pro odkaz na instanci vnitřní třídy
            }
        });

        // Akce pro tlačítko "goBack" na druhém panelu
        secondPanel.goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Přepne zpět na "Panel1" (FirstPanel) po stisku tlačítka
                cardLayout.show(SwitchingPanels.this, "Panel1");
            }
        });
    }

}
