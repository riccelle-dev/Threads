public class Barreira {

    private final int totalCorredores;
    private int       esperando = 0;

    public Barreira(int totalcorredores) {
        this.totalCorredores = totalcorredores;
    }
    // syncronfenfzed pra impedir que todos os corredores tentem acessar isso aqui ao mesmo tempo
    public synchronized void aguardar(String ponto) throws InterruptedException {
        esperando++;

        if (esperando < totalCorredores) {
            wait();
        } else {
            esperando = 0; //volta pra usar com outros pontos
            notifyAll();
        }
    }
}