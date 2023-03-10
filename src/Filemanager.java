import java.io.*;
import java.util.ArrayList;

public class Filemanager {

    String FILE_PATH = "./src/main/java/org/phonebook/";
    String FILE_NAME_EXPORT = "export.csv";
    String FILE_PATH_FULL = FILE_PATH+FILE_NAME_EXPORT;
    public void fileExport(ArrayList<Phonebook> pb){
        try(FileWriter writer = new FileWriter(FILE_PATH + FILE_NAME_EXPORT, false))
        {
            for(Phonebook i: pb){
                String text = i.getName()+";"+i.getPhone()+";"+i.getCity();
                writer.write(text);
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    public void fileImport(ArrayList<Phonebook> pb){
        try {
            File file = new File(FILE_PATH_FULL);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] tmp = line.split(";");
                pb.add(new Phonebook(tmp[0], tmp[1], tmp[2]));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
