package jet.app.io;

import java.io.IOException;

public class Exec {
    public static void run(String commandLine){
        try {
            Runtime.getRuntime().exec(commandLine);
            System.out.println(commandLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
