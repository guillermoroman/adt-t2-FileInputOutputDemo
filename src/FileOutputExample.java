import java.io.*;

public class FileOutputExample {
    public static void main(String[] args) {
        //printCharacters();
        //printCharactersFromArray();
        //printFromLoop();
        //readCharacter();
        readCharactersWihLoop();

    }


    private static void printCharacters() {
        try {
            OutputStream fos= new FileOutputStream("archivo.txt");

            fos.write(104);
            fos.write(105);

            fos.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo");
        }
    }

    private static void printCharactersFromArray() {
        try (OutputStream fos = new FileOutputStream("archivo.txt", true)){

            String message = "Hello there!\n";
            byte[] messageInBytes = message.getBytes();

            fos.write(messageInBytes, 5, 7);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printFromLoop(){
        try(OutputStream fos = new FileOutputStream("archivo.txt", true)){

            char numero = '0';
            System.out.println((int)numero);

            char salto = '\n';
            fos.write((int)salto);

            for(int i = 48; i <= 57; i++){
                fos.write(i);
            }

        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo");
        }
    }

    private static void readCharacter(){
        try(InputStream fis = new FileInputStream("archivo.txt")){

            System.out.println(fis.read());
            System.out.println((char)fis.read());

        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.err.println("Error al leer del archivo");
        }
    }

    private static void readCharactersWihLoop(){
        try(InputStream fis = new FileInputStream("archivo.txt")){

        byte[] miArray = new byte[4096];

        int bytesLeidos = fis.read(miArray);
            System.out.println("Bytes leidos: " + bytesLeidos);



        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.err.println("Error al leer del archivo");
        }
    }
}
