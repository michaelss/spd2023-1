package br.ulbra.servidorrmi.calculadora;

import java.rmi.RemoteException;

public class CalculadoraServiceImpl implements CalculadoraService {

    @Override
    public int somar(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public ResultadoDivisao dividir(int dividendo, int divisor) throws RemoteException {
        int quociente = dividendo / divisor;
        int resto = dividendo % divisor;
        
        ResultadoDivisao resultado = new ResultadoDivisao(quociente, resto);
        return resultado;
    }
    
}
