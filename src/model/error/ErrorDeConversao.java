package model.error;

public class ErrorDeConversao extends RuntimeException {
    private String messagem;
    public ErrorDeConversao(String messagem) {
        this.messagem = messagem;
    }

    public String getMessagem() {
        return messagem;
    }
}
