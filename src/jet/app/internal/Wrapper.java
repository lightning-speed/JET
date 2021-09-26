package jet.app.internal;

import jet.app.io.Exec;
import jet.app.util.FileManager;

public class Wrapper {
    public void build_objects(){
        Exec.run("win32\\tcc\\tcc.exe -c "
                + Core.C_FILE_PATH
                + " -o  data\\core.o");
    }
    public void build_icon(){
        if(Core.ICON_PATH.length()>0) {
            FileManager.copyFile(Core.ICON_PATH, "data\\icon.ico");
            Exec.run("win32\\windres.exe data\\icon.rc -O coff -o data\\icon.o");
        }
    }
    public void build_executable(){
        String icon = " data\\icon.o ";
        if(Core.ICON_PATH==null)icon="";
        Exec.run("win32\\tcc\\tcc.exe "
                        + "data\\core.o "
                        + icon
                        + "-o "+Core.OUTPUT_PATH
                );
    }
}
