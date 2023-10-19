public class C211 {


    public static void main(String[] args) {

        int numHebras = 100;
        Thread[] hebras = new Thread[numHebras];

        for (int i=0;i < numHebras;i++){
            Thread t1 = new Thread(new Hebras4(i));
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


class Hebras4 extends Thread{

    private int identificador;

    public Hebras4(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public void run() {
        if (identificador % 3 == 0 && identificador % 5 == 0){
            System.out.println("La hebra " + identificador + " es divisible por 3 y 5");
        }
    }

}
