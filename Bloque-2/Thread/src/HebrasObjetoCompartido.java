public class HebrasObjetoCompartido extends CuentaIncrementos {

    public static void main(String[] args) {
        CuentaIncrementos cuentaIncrementos = new CuentaIncrementos();


        int numHebras =4;
        Thread[] hebras = new Thread[numHebras];

        for (int i=0;i < numHebras;i++){
            Thread t1 = new Thread(new Hebras3(i,cuentaIncrementos));
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


        System.out.println(cuentaIncrementos.contador);

    }


}


class Hebras3 extends Thread {

    private int identificador;


    CuentaIncrementos cuentaIncrementos;
    public Hebras3(int identificador,CuentaIncrementos cuentaIncrementos) {
        this.identificador = identificador;
        this.cuentaIncrementos = cuentaIncrementos;
    }

    @Override
    public void run() {

        System.out.println("Hebra " + identificador);

        for (int i = 0; i < 1000; i++) {
            cuentaIncrementos.incrementarContador();
        }

        System.out.println("Hebra " + identificador);
    }

}
