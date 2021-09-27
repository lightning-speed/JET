package jet.app;

import jet.app.internal.Core;
import jet.app.internal.Wrapper;
import jet.app.internal.Writer;
import jet.app.ui.Window;

import javax.swing.*;

public class Main {
    public static Window window;
    public static void main(String args[]){
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
        } catch (Exception e) {
            e.printStackTrace();
        }
        window = new Window();

    }
}
