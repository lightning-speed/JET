package jet.app.ui;

import javax.swing.*;

public class Window  extends JFrame{
    public static AppView app_view;
    public Window(){
        super("JET - Bat to Exe converter");
        this.setIconImage(new ImageIcon("icons/icon.png").getImage());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(450,400);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        app_view = new AppView();
        this.setContentPane(app_view);
        this.setSize(450,401);
        this.setSize(450,400);
    }
}
