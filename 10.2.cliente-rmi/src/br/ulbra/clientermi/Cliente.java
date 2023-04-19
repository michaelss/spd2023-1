package br.ulbra.clientermi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.ulbra.servidorrmi.calculadora.CalculadoraService;
import br.ulbra.servidorrmi.calculadora.ResultadoDivisao;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry();
        
        CalculadoraService calc = (CalculadoraService) registry.lookup("CalculadoraService");


        int resposta = calc.somar(1, 2);
        System.out.println("\n\n>>> O resultado da soma é " + resposta);


        ResultadoDivisao resultado = calc.dividir(5, 2);
        System.out.println(">>> O quociente da divisão é " + resultado.getQuociente());
        System.out.println(">>> O resto da divisão é " + resultado.getResto());
    }
}
