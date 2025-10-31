package br.com.alura.screenmatch.excecao;

public class ErroDeConvesaoDeAnoException extends RuntimeException {
    private String mensagem;
    public ErroDeConvesaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
