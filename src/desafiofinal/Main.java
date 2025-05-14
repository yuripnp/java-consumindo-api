package desafiofinal;

public class Main {
    public static void main(String[] args) {
        ConsultaCep consultaCep = new ConsultaCep();
        Endereco endereco = consultaCep.buscaEndereco("66");
        System.out.println(endereco);
    }
}
