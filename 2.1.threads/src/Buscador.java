import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Buscador implements Runnable{

    private String arquivo;
    private String texto;

    public Buscador(String arquivo, String texto) {
        this.arquivo = arquivo;
        this.texto = texto;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File(arquivo));
            int numLinha = 1;
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                if (linha.toLowerCase().contains(texto.toLowerCase())) {
                    System.out.println(arquivo + ": linha " + numLinha);
                }
                numLinha++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
