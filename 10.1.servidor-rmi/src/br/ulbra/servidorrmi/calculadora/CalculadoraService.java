package br.ulbra.servidorrmi.calculadora;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraService extends Remote {
    
    int somar(int a, int b) throws RemoteException;

    ResultadoDivisao dividir(int dividendo, int divisor) throws RemoteException;
}
