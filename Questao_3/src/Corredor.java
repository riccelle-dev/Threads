public class Corredor extends Thread {

    private static final int pontos = 3;
    private final Barreira barreira;
    private final Barreira barreiraSaida;

    public Corredor(Barreira barreira, Barreira barreiraSaida) {
        this.barreira      = barreira;
        this.barreiraSaida = barreiraSaida;
    }

    public void run() {
        try {
            System.out.println(getName() + " está pronto no ponto A");
            barreiraSaida.aguardar("A");

            for (int p = 1; p <= pontos; p++) {
                Thread.sleep((long) (Math.random() * 1000)); //gera u numero aleatorio 0-1 e usa o sleep pra ele fazer uma pausa pra simular a corrida
                // https://www.digitalocean.com/community/tutorials/thread-sleep-java
                System.out.println(getName() + " chegou no ponto " + (char)('A' + p));
                barreira.aguardar(String.valueOf((char) ('A' + p))); // usei tabela asci pra não ter que ficar escrevendo os pontos, já que pede a quantidade no inicio
            }

            System.out.println(getName() + " terminou no ponto " + (char)('A' + pontos));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}