package chapter7;

import java.io.*;

/**
 * FileStream Demo class
 */
public class FileStreamDemo {
    FileInputStream fin, fin2;
    FileOutputStream fout;
    SequenceInputStream seq;
	ObjectOutputStream objectOutputStream;
	ObjectInputStream objectInputStream;
    /**
     * @param file takes file as an arguments
     * @param Data takes data to write in the file
     * @throws IOException
     */
    void fileoutputstream (File file, String Data) throws IOException {
        try {
            fout = new FileOutputStream(file);
            String s = Data;
            byte b[] = s.getBytes();//converting string into byte array
            fout.write(b);
          fout.flush();
            fout.close();
            System.out.println("success...");
        } catch (Exception e) {
            throw new IOException("File Write Error");
        }
    }
    
    /**
     * FileOutputStream needs one parameter as file and return data as StringBuffer
     *
     * @param file takes file as an arguments
     * @return string buffer
     * @throws IOException
     */
    StringBuffer fileinputstream (File file) throws IOException {
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
        } catch (FileNotFoundException e) {
            System.err.println("Given file " + file + " not Found!");
        } catch (IOException e) {
            throw new IOException("File Read Error");
        }
        return s;
    }
    
    StringBuffer seqinputstream (File file1, File file2) throws IOException {
        StringBuffer s = new StringBuffer();
        try {
            fin = new FileInputStream(file1);
            fin2 = new FileInputStream(file2);
            seq = new SequenceInputStream(fin, fin2);
            
            int i = 0;
            /*
             * Reads the file to the EOF
             * */
            while ((i = seq.read()) != -1) {
                /*
                 * Append the characters into the Buffer
                 * */
                s.append((char) i);
            }
            fin.close();
            fin2.close();
            seq.close();
            System.out.println("success...");
        } catch (FileNotFoundException e) {
            System.err.println("Given file " + file1 + "/" + file2 + " not Found!");
        } catch (IOException e) {
            throw new IOException("File Read Error");
        }
        return s;
    }
	
	void transferObject (User user, File file) {
		try {
			fout = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fout);
			try {
				objectOutputStream.writeObject(user);
			} catch (Exception e) {
				System.out.println("Object parsing Err: " + e.getMessage());
			} finally {
				objectOutputStream.flush();
				objectOutputStream.close();
				fout.close();
			}
		} catch (Exception e) {
			System.out.println("File parsing Err: " + e.getMessage());
		}
	}
	
	User readObject (File file) {
		User user = null;
		try {
			fin = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fin);
			try {
				user = (User) objectInputStream.readObject();
			} catch (Exception e) {
				System.out.println("Object parsing Err: " + e.getMessage());
			} finally {
				objectOutputStream.flush();
				objectOutputStream.close();
				fout.close();
			}
		} catch (Exception e) {
			System.out.println("File parsing Err: " + e.getMessage());
		}
		return user;
	}
}
