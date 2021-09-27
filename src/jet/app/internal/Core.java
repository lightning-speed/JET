package jet.app.internal;

import jet.app.ui.AppView;
import jet.app.util.FileManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Core {
    public static Wrapper wrapper;
    public static String BAT_PATH;
    public static String OUTPUT_PATH;
    public static String ICON_PATH;
    public static String C_FILE_PATH = "win32/main.c";
    public static void setConfig(String bat, String output, String icon){
        BAT_PATH = bat;
        OUTPUT_PATH = output;
        ICON_PATH = icon;
        FileManager.write("data/user_data",BAT_PATH+"\n"+OUTPUT_PATH+"\n"+ICON_PATH);
    }
    public static void Build(){
        AppView.log_area.setText("");
        char co = '"';
        BAT_PATH=co+BAT_PATH+co;
        OUTPUT_PATH=co+OUTPUT_PATH+co;
        wrapper = new Wrapper();
        AppView.log_area.setForeground(Color.BLACK);
        if(new File(BAT_PATH.replace(""+co,"")).exists()&&!new File(BAT_PATH.replace(""+co,"")).isDirectory()){
            AppView.log_area.setText("Building...");
        }else{
            AppView.log_area.setForeground(Color.RED);
            AppView.log_area.setText("Error Batch File Doesn't Exists");
            AppView.log_area.setBorder((BorderFactory.createLineBorder(new Color(200,50,70),3)));

            return;
        }
        if(ICON_PATH.length()>0){
            if(new File(ICON_PATH).exists()){
                AppView.log_area.setText( AppView.log_area.getText()+"\nAdding Icon...");
                wrapper.build_icon();

            }
            else{
                AppView.log_area.setForeground(Color.RED);
                AppView.log_area.setText("Error Icon File Doesn't Exists");
                AppView.log_area.setBorder((BorderFactory.createLineBorder(new Color(200,50,70),3)));
                return;
            }
        }
        wrapper.build_objects();
        AppView.log_area.setText( AppView.log_area.getText()+"\nBuilding Objects...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AppView.log_area.setText( AppView.log_area.getText()+"\nWrapping...");
                    Thread.sleep(1300);
                    wrapper.build_executable();
                    AppView.log_area.setText( AppView.log_area.getText()+"\nDone!");
                    AppView.log_area.setBorder((BorderFactory.createLineBorder(new Color(100,200,100),3)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
