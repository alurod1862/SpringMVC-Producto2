import java.lang.reflect.Array;

public class VectorHebra {


    public static void main(String[] args) {

        int numHebras =5;
        Thread[] hebras = new Thread[numHebras];

        for (int i=0;i < numHebras;i++){
            Thread t1 = new Thread(new Hebras(i));
            hebras[i] = t1;
            t1.start();
        }



        for (Thread thread : hebras){
            try{
             thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("\nTodas las hebras han finalizado");


    }

}


class Hebras extends Thread{

    private int identificador;

    public Hebras(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Soy la hebra " + identificador);
        }
    }

}
