package a2025;

import java.util.Scanner;

public class Desafio {
        public static void main(String[] args) {
            double saldo = 0.0 ;
            int escolha = 0 ;
            double valorDeTransalacoes = 0.0 ;
            Scanner leitura = new Scanner(System.in);

            while (escolha != 4) {
                System.out.println("""
                                Operacoes
                                
                                1- Consultar saldos
                                2- Receber valor
                                3- Transferir valor
                                4- Sair
                                """);

                System.out.println("Digite a opcao desejada:");
                escolha = leitura.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Saldo: R$ " + saldo);
                        break;
                    case 2:
                        System.out.println("Informe o valor a receber:");
                        valorDeTransalacoes = leitura.nextDouble();
                        saldo = saldo + valorDeTransalacoes;

                        System.out.println("Saldo Atualizado: R$ " + saldo);
                        break;
                    case 3:
                        System.out.println("Informe o valor a ser transferido:");
                        valorDeTransalacoes = leitura.nextDouble();
                        saldo = saldo - valorDeTransalacoes;

                        System.out.println("Saldo Atualizado: R$ " + saldo);
                        break;
                    case 4:
                        break;

                    default:
                        System.out.println("Opcao invalida");
                        break;

                }

            }

        }


}
