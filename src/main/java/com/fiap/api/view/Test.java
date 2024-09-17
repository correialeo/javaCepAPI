package com.fiap.api.view;

import com.fiap.api.services.ViaCepService;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ViaCepService viaCepService = new ViaCepService();
        Scanner leitor = new Scanner(System.in);
        boolean finish = true;

        while (finish){
            System.out.println("Digite 1 para buscar cep e 2 para sair");
            Integer opcao = leitor.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite o CEP");
                    String cep = leitor.next();
                    System.out.println(viaCepService.getEndereco(cep));
                    break;
                case 2:
                    finish = false;
                    break;
            }
        }
    }
}
