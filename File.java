import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    public static void main(String[] args) throws InterruptedException {

        final long before = System.currentTimeMillis();
        Thread rewrite1 = new Thread() {
            @Override
            public void run() {
                try (BufferedReader bReader = new BufferedReader
                        (new FileReader("F:\\UUU\\text1.txt")); FileWriter write = new FileWriter("1.txt")
                ) {
                    String string;
                    while ((string = bReader.readLine()) != null) {
                        write.write(string);
                        write.write(System.getProperty("line.separator"));
                    }
                    System.out.println("exelent");

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        };

        Thread rewrite2 = new Thread() {

            @Override
            public void run() {

                try (BufferedReader bufferedReader = new BufferedReader
                        (new FileReader("F:\\UUU\\text2.txt")); FileWriter writer = new FileWriter("2.txt")
                ) {
                    String string;
                    while ((string = bufferedReader.readLine()) != null) {
                        writer.write(string);
                        writer.write(System.getProperty("line.separator"));
                    }
                    System.out.println("exelent");

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        rewrite1.start();
        rewrite2.start();
        rewrite2.join();
        final long after = System.currentTimeMillis();
        System.out.printf("Колличество мс %d", (after - before));

    }
}

