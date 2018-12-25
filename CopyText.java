import java.io.*;


public class CopyText {
    public static void main(String[] args) throws InterruptedException {


        Thread rewrite1 = new Thread() {
            @Override
            public void run() {
                final long before = System.currentTimeMillis();
                try (BufferedReader bReader = new BufferedReader
                        (new FileReader("F:\\UUU\\text1.txt"));FileWriter write = new FileWriter("1.txt")
                ){


                    String string;
                    while ((string = bReader.readLine()) != null) {
                        write.write(string);
                        write.write(System.getProperty("line.separator"));
                    }
                    final long after = System.currentTimeMillis();
                    System.out.printf("Успешно1 Колличество мс %d", (after - before) );
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }


            }
        };
        Thread rewrite2 = new Thread() {

            @Override
            public void run() {
                final long before = System.currentTimeMillis();
                try (BufferedReader bufferedReader = new BufferedReader
                        (new FileReader("F:\\UUU\\text2.txt"));FileWriter writer = new FileWriter("2.txt")
                ){


                    String string;
                    while ((string = bufferedReader.readLine()) != null) {
                        writer.write(string);
                        writer.write(System.getProperty("line.separator"));
                    }
                    final long after = System.currentTimeMillis();
                    System.out.printf("\nУспешно2 Колличество мс %d", (after - before) );
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }


            }
        };
        rewrite1.start();
        rewrite2.start();

    }
}

