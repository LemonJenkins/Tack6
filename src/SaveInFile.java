import exception.Save;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class SaveInFile implements Save {
    @Override
    public void save(String stringRecording, String pathFile) {
        File file = new File(pathFile);
        if (file.exists()) {
            throw new NullPointerException("File already exists");
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileWriter fileWriter = new FileWriter(file, false);
                fileWriter.write(stringRecording);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error! Can not write a file.");
            }
        }
    }
}
