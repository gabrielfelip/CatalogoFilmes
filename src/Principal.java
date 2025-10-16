import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class Principal {

    // Méthod principal da aplicação.
    // É o ponto de entrada do programa (o primeiro method executado ao rodar o código).
    public static void main(String[] args) {

        // Criação de um novo objeto da classe Filme.
        // Aqui estamos a instanciar a classe e guardando na variável 'meuFilme'.
        Filme meuFilme = new Filme();

        // Configuração dos atributos do filme utilizando os métodos 'setters'.
        // Esses métodos garantem que os dados sejam atribuídos de forma controlada.
        meuFilme.setNome("O Poderoso Chefão");
        meuFilme.setAnoDeLancamento(1972);
        meuFilme.setDuracaoEmMinutos(175);
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());

        // Exibe no console as informações do filme, chamando o method da própria classe Filme.
        meuFilme.exibeFichaTecnica();

        // Adiciona três avaliações ao filme, simulando notas de diferentes usuários.
        meuFilme.avalia(8);
        meuFilme.avalia(9);
        meuFilme.avalia(9);
        // Exibe o total de avaliações realizadas.
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println("Média das avaliações: " + meuFilme.pegaMedia());


        Serie friends = new Serie();
        friends.setNome("Friends");
        friends.setAnoDeLancamento(1994);
        friends.exibeFichaTecnica();
        friends.setTemporadas(10);
        friends.setMinutosPorEpisodio(30);
        friends.setEpisodiosPorTemporada(24);
        System.out.println("Duração para maratonar Friends: " + friends.getDuracaoEmMinutos());

        Filme filmeDois = new Filme();

        filmeDois.setNome("O resgate do soldado Ryan");
        filmeDois.setAnoDeLancamento(1998);
        filmeDois.setDuracaoEmMinutos(210);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(filmeDois);
        calculadora.inclui(friends);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(friends);
        episodio.setTotalDeVisualizacoes(300);
        filtro.filtra(episodio);
    }

}















































