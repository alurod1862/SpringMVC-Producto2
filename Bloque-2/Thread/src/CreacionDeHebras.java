import java.lang.reflect.Array;

public class CreacionDeHebras {


    public static void main(String[] args) {

        Hebras1 hebras1 = new Hebras1(0);
        hebras1.start();
        Thread hebra2 = new Thread(new Hebras2(1));
        hebra2.start();


        try{
            hebra2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }



}

class Hebras1 extends Thread {

    private int identificador;

    public Hebras1(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Soy la hebra " + identificador);
        }
    }

}


class Hebras2 implements Runnable {

    private int identificador;

    public Hebras2(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Soy la hebra " + identificador);
        }
    }

}