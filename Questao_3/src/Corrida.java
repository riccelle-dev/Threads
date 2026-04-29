public class Corrida {

    private static final int equipes = 2;
    private static final int todosCorredores = 3;

    public static void main(String[] args) throws InterruptedException {

        Corredor[][] corredores = new Corredor[equipes][todosCorredores]; //array pq precisa saber equipe e id corredor
        Barreira barreiraSaida = new Barreira(equipes * todosCorredores); // preciso desse construtor para que eu possa usar o aguardar pra todos começarem juntos

        for (int i = 0; i < equipes; i++) {
            String   nomeEquipe = "equipe " + (i + 1);
            Barreira barreira   = new Barreira(todosCorredores);

            for (int c = 0; c < todosCorredores; c++) {
                corredores[i][c] = new Corredor(barreira, barreiraSaida);
                corredores[i][c].setName(nomeEquipe + " corredor " + (c + 1));
            }
        }

        for (int i = 0; i < equipes; i++)
            for (Corredor c : corredores[i]) c.start();

        for (int j = 0; j < equipes; j++)
            for (Corredor c : corredores[j]) c.join();

        System.out.println("acabou corrida");
    }
}