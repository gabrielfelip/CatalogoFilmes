package br.com.alura.screenmatch.modelos;

public class Titulo {
    // ==============================
    // ATRIBUTOS PRIVADOS
    // ==============================

    // Modificador de acesso 'private'
    // Este modificador restringe o acesso a este atributo ou méthod apenas dentro da própria classe.
    // Somente a classe 'br.com.alura.screenmatch.modelos.Filme' pode acessar ou modificar este atributo.
    // Isso garante o encapsulamento, protegendo a integridade dos dados.
    private String nome;
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;

    // Atributos abaixo são usados internamente para o controle de avaliações do filme.
    private double somaDasAvaliacoes; // Armazena a total das notas recebidas nas avaliações.
    private int totalDeAvaliacoes;    // Armazena o número total de avaliações feitas.


    // ==============================
    // MÉTODOS FUNCIONAIS
    // ==============================

    // Méthod responsável por exibir as informações principais do filme.
    // Utiliza os atributos da classe para imprimir uma ficha técnica no console.
    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
        System.out.println("Duração em minutos: " + duracaoEmMinutos);
        System.out.println("Incluído no plano: " + incluidoNoPlano);
    }

    // Méthod para registrar uma nova avaliação.
    // Cada vez que o filme é avaliado, a nota recebida é somada em 'somaDasAvaliacoes'
    // e o total de avaliações é incrementado em 1.
    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    // Méthod para calcular e retornar a média das avaliações do filme.
    // O cálculo é feito dividindo a soma das avaliações pelo total de avaliações.
    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }


    // ==============================
    // MÉTODOS GETTERS (ACESSO)
    // ==============================

    // Getters servem para obter (ler) os valores dos atributos privados.
    // Eles garantem que o acesso aos dados seja controlado e seguro.

    public String getNome() {
        return this.nome;
    }

    public int getAnoDeLancamento() {
        return this.anoDeLancamento;
    }

    public boolean getIncluidoNoPlano() {
        return this.incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return this.totalDeAvaliacoes;
    }


    // ==============================
    // MÉTODOS SETTERS (MODIFICAÇÃO)
    // ==============================

    // Setters servem para modificar (alterar) os valores dos atributos privados.
    // Dessa forma, a classe continua protegida, mas ainda permite atualização dos dados.

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
}












































