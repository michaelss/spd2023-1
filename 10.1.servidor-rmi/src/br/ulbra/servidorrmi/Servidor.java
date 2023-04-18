package br.ulbra.servidorrmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.ulbra.servidorrmi.calculadora.CalculadoraService;
import br.ulbra.servidorrmi.calculadora.CalculadoraServiceImpl;

public class Servidor {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);

        CalculadoraService calculadoraService = new CalculadoraServiceImpl();
        CalculadoraService stubMsgService = (CalculadoraService) UnicastRemoteObject
                .exportObject((CalculadoraService) calculadoraService, 0);
        registry.rebind("CalculadoraService", stubMsgService);
    }
}
