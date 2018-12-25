import java.io.*;



public class CopySimple {

    public static void main(String[] args) {
        final long before = System.currentTimeMillis();
        try (FileInputStream fstream = new FileInputStream("F:\\UUU\\tex1.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(fstream, "UTF-8"));
             FileWriter writer = new FileWriter("3.txt", false)) {

            String strLine;
            while ((strLine = br.readLine()) != null) {
                writer.write(strLine);
                writer.write(System.getProperty("line.separator"));
            }

        } catch (IOException e) {
            System.out.println("Ошибка ");
        }
        final long after = System.currentTimeMillis();
        System.out.printf("Колличество мс %d", (after - before) );
    }

}