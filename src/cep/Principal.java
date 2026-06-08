package cep;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        ConsultaCep consultaCep = new ConsultaCep();
        try {
            Endereco novoEndereco = consultaCep.buscaEndereco("94198040");
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicacao");
        }
    }
}
