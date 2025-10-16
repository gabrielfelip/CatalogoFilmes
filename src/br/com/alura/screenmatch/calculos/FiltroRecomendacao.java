package br.com.alura.screenmatch.calculos;

public class FiltroRecomendacao {

    public void filtra (Classificavel classificavel) {
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Preferidos da galera!");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Vale a pena assistir");
        } else {
            System.out.println("Coloque na sua lista de espera");
        }
    }
}
