import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Log {
    public void LogText(String log){
        Path path = Paths.get("F:\\Java_Projects\\Java_Seminar_oop\\Seminar_5_OOP_HW\\src\\log.csv");
        try {
            Files.write(path, log, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
