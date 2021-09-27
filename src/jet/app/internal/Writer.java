package jet.app.internal;

import jet.app.util.FileManager;

public class Writer {
    String BAT_PATH;
    String CONTENT;
    public Writer(String bat_path){
        this.BAT_PATH = bat_path;
    }
    public void CreateContent(){
        char cotes = '"';
        CONTENT = CONTENT.replace("\\","\\\\");
        CONTENT = CONTENT.replace("\n","\\"+"n");
        CONTENT = CONTENT.replace("\r","\\"+"r");
        CONTENT = "char * getData(){ \nreturn "+cotes+CONTENT+cotes+";\n}";
    }
    public void write(){
        CONTENT = FileManager.read(BAT_PATH);
        CreateContent();
        FileManager.write("win32/run.h",CONTENT);
    }
}
