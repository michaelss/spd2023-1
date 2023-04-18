package br.ulbra.servidorrmi.calculadora;

import java.rmi.RemoteException;

public class CalculadoraServiceImpl implements CalculadoraService {

    @Override
    public int somar(int a, int b) throws RemoteException {
        return a + b;
    }
    
}
