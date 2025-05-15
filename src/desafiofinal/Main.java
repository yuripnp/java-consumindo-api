package desafiofinal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um numero de cep para consulta");
        var cep = scanner.nextLine();
        ConsultaCep consultaCep = new ConsultaCep();
        try {
            Endereco endereco = consultaCep.buscaEndereco(cep);
            System.out.println(endereco);
            GeradorArquivo geradorArquivo = new GeradorArquivo();
            geradorArquivo.createJson(endereco);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação com Error");
        }

    }
}
