import javax.swing.*;

public class FirstFrame extends JFrame {

    private FirstPanel panel;

    public FirstFrame() {
        this.panel = new FirstPanel();
        this.setSize(250, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setResizable(false);
        //this.pack();
    }

    public void turnOnFrame(){
        this.setVisible(true);
    }

}
