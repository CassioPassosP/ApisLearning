package a2025;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao CFlix");
        System.out.println("""
                Filme: 
                
                Top gun: Maverick
                """);

        int anoDeLancamento = 2022;

        boolean incluidoNoPlano = true;
        double notaDeFilme = 8.1;

        //media calculada em cima de 3 pessoas
        double media = ( 9.8 + 6.3 + 8.0 )/ 3;
        System.out.println(media);
        String sinopse;
        sinopse = """
                Filme de aventura 
                com gala dos anos 80
                Ano de lancamento: 
                """ + anoDeLancamento;
        System.out.println(sinopse);

        int classificacao;
        classificacao = (int) (media /2);
        System.out.println(classificacao);

    }
}