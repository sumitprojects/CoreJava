package chapter7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamDemo {
    FileInputStream fin;
    FileOutputStream fout;
  
  /**
   * @param file takes file as an arguments
   * @param Data takes data to write in the file
   * @throws IOException
   */
    void fileoutputstream(File file, String Data) throws IOException {
        try {
            fout = new FileOutputStream(file);
            String s = Data;
            byte b[] = s.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        } catch (Exception e) {
            throw new IOException("File Write Error");
        }
    }
  
  /**
   * FileOutputStream needs one parameter as file and return data as StringBuffer
     * @param file takes file as an arguments
   * @return string buffer
   * @throws IOException
   */
  StringBuffer fileinputstream(File file) throws IOException {
        StringBuffer s = new StringBuffer();
        try {
            fin = new FileInputStream(file);
            int i = 0;
            /*
             * Reads the file to the EOF
             * */
            while ((i = fin.read()) != -1) {
                /*
                 * Append the characters into the Buffer
                 * */
                s.append((char) i);
            }
            fin.close();
            System.out.println("success...");
        } catch (Exception e) {
            throw new IOException("File Read Error");
        }
        return s;
    }
}
