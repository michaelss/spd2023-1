
public class Contador {

    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void incrementar() {
        int n = this.numero;
        this.numero = n + 1;
    }
    
}