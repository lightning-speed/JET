package jet.app.io;

import jet.app.Main;
import jet.app.util.FileManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
    public static String getLastOpenedDir(){
        return FileManager.read("data/user_path");
    }
    public static void setLastOpenedDir(String in){
        FileManager.write("data/user_path",in);
    }
    public static String chooseFile(String show,String rs){
        FileNameExtensionFilter restrict = new FileNameExtensionFilter(show, rs);
        JFileChooser j = new JFileChooser(getLastOpenedDir());
        j.setAcceptAllFileFilterUsed(false);
        j.addChoosableFileFilter(restrict);
        int r = j.showOpenDialog(Main.window);
        if (r == JFileChooser.APPROVE_OPTION){
            setLastOpenedDir(j.getSelectedFile().getAbsolutePath());;
           return (j.getSelectedFile().getAbsolutePath());
        }
        else{
         return null;
        }
    }
    public static String saveFile(){
        JFileChooser j = new JFileChooser(getLastOpenedDir());
        int r = j.showSaveDialog(Main.window);
        if (r == JFileChooser.APPROVE_OPTION){
            setLastOpenedDir(j.getSelectedFile().getAbsolutePath());;
            return (j.getSelectedFile().getAbsolutePath());
        }
        else{
            return null;
        }
    }
}
