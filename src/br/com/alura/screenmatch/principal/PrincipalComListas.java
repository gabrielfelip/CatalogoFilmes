package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        var filmeDois = new Filme("Dogville", 2003);
        filmeDois.avalia(7);
        Filme filmeTres = new Filme("Avatar", 2023);
        filmeTres.avalia(7);
        Serie lost = new Serie("Lost", 2000);


        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(filmeDois);
        lista.add(filmeTres);
        lista.add(lost);

        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }

        }
        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Nicolas Cage");
        buscaPorArtista.add("Keanu Reeves");
        System.out.println("Artistas favoritos: " + buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Artistas favoritos ordenados: " + buscaPorArtista);

        Collections.sort(lista);
        System.out.println("Titulos ordenados: " + lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Titulos ordenados por ano de lançamento: " + lista);
    }

    }

