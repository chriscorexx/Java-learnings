import java.io.*;

class PracticalNineteen {
    public static void main(String[] args) {
        try {
            // Write content to file
            FileWriter fw = new FileWriter("source.txt");
            fw.write("Welcome to Java Programming");
            fw.close();

            // Read content from file
            FileReader fr = new FileReader("source.txt");
            int ch;

            System.out.println("File Contents:");
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            fr.close();

            // Copy content from one file to another
            FileReader fin = new FileReader("source.txt");
            FileWriter fout = new FileWriter("destination.txt");

            while ((ch = fin.read()) != -1) {
                fout.write(ch);
            }

            fin.close();
            fout.close();

            System.out.println("\nFile copied successfully.");

            // Write bytes using FileOutputStream
            FileOutputStream fos = new FileOutputStream("bytefile.txt");
            String data = "Hello Java";
            fos.write(data.getBytes());
            fos.close();

            // Read bytes using FileInputStream
            FileInputStream fis = new FileInputStream("bytefile.txt");

            System.out.println("Byte File Contents:");
            int b;

            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }

            fis.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
