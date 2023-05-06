package exercise.file_IOExercise;

import java.io.*;

public class IOAndFile {
    public static void main(String[] args) throws IOException {
        String pathName = "src/main/java/exercise/file_IOExercise/source";
        String pathName1 = "src/main/java/exercise/file_IOExercise/dest1";
        String pathName2 = "src/main/java/exercise/file_IOExercise/dest2";
        File file = new File(pathName);
        if(!file.exists()){
            file.createNewFile();
        }
        File file1 = new File(pathName1);
        File file2 = new File(pathName2);
        OutputStream outputStream1 = new FileOutputStream(file1);
        OutputStream outputStream2 = new FileOutputStream(file2);
        int temp;
        int len;
        if(file1.exists() && file2.exists()){
            InputStream inputStream1 = new FileInputStream(file);
            InputStream inputStream2 = new FileInputStream(file);
            while((temp = inputStream1.read())!=-1){
                outputStream1.write(temp);
            }
            byte[] bytes = new byte[1024];
            while((len = inputStream2.read(bytes))!=-1){
                outputStream2.write(bytes, 0, len);
            }
            outputStream1.close();
            outputStream2.close();
        }
    }
}
