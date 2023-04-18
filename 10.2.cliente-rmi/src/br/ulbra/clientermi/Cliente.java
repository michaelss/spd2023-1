package br.ulbra.clientermi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.ulbra.servidorrmi.calculadora.CalculadoraService;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry();
        
        CalculadoraService calc = (CalculadoraService) registry.lookup("CalculadoraService");
        int resposta = calc.somar(1, 2);

        System.out.println("\n\n >>> O resultado da soma é " + resposta);
    }
}
