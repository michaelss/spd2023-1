package br.ulbra.servidorrmi.calculadora;

import java.io.Serializable;

public class ResultadoDivisao implements Serializable {
    
    private int quociente;
    private int resto;

    public ResultadoDivisao(int quociente, int resto) {
        this.quociente = quociente;
        this.resto = resto;
    }

    public int getQuociente() {
        return quociente;
    }

    public void setQuociente(int quociente) {
        this.quociente = quociente;
    }

    public int getResto() {
        return resto;
    }

    public void setResto(int resto) {
        this.resto = resto;
    }

}
