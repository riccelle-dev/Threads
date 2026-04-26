public class BuscaForcaBruta {

    public static void main(String[] args) throws InterruptedException {

        int      totalThreads = 4;
        String   senha = "8762536477";
        String[] resultado    = new String[2];

        MinhaThread[] buscador = new MinhaThread[totalThreads];
        for (int i = 0; i < totalThreads; i++) {
            buscador[i] = new MinhaThread(i, totalThreads, senha, resultado);
        }
        for (MinhaThread b : buscador) b.start();

        //new Thread(0, totalThreads, senha, resultado).start();

        synchronized (resultado) {
            while (resultado[0] == null) {
                resultado.wait();
            }
        }

        System.out.println("Senha encontrada: " + resultado[0]);
        System.out.println("Thread vencedora: " + resultado[1]);

        for (Thread b : buscador) b.join();
    }
}