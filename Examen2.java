
public class Examen2 {
    public static void main(String args[]) {
        int numHebras=4;
        long vector[] = {1,2,3,4,5,6,7,8,9,
                10,11,12,3,14,15,16,17,18,19,20,
                21,22,23,24,25,26,27,28,29,30,
                31,32,33,34,35,36,37,38,39,40};



        implementacionSecuencial(vector);

        implementacionCiclica(vector, numHebras);



    }

    static void implementacionSecuencial(long[] vector) {
        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación secuencial.");

        t1 = System.nanoTime();

        for (int i =0;i<vector.length;i++){
            if (vector[i] % 2 == 0 && vector[i] % 3 == 0 && vector[i] % 5 == 0 ){
                System.out.println(vector[i] +" es multipo de 2,3,5");

            }
        }


        t2 = System.nanoTime();
        tt = ((double) (t2 - t1)) / 1.0e9;

        System.out.println("Tiempo secuencial (seg.):\t\t\t" + tt);
    }

    static void implementacionCiclica(long[] vector, int numHebras) {
        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación cíclica.");

        MiHebraCiclica2 v[] = new MiHebraCiclica2[numHebras];

        t1 = System.nanoTime();

        for (int i = 0; i < numHebras; i++) {
            v[i] = new MiHebraCiclica2(i, numHebras, vector);
            v[i].start();
        }

        for (int i = 0; i < numHebras; i++) {
            try {
                v[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }


        t2 = System.nanoTime();
        tt = ((double) (t2 - t1)) / 1.0e9;

        System.out.println("Tiempo cíclico (seg.):\t\t\t" + tt);
    }



}


class MiHebraCiclica2 extends Thread {
    private int idHebra;
    private int numHebra;
    private long vector[];

    public MiHebraCiclica2(int i,int numHebras,long vector[] ){
        this.idHebra = i;
        this.numHebra = numHebras;
        this.vector = vector;
    }

        @Override
        public void run() {
            for (int i = idHebra;i < vector.length;i+=numHebra){
                if (vector[i] % 2 == 0 && vector[i] % 3 == 0 && vector[i] % 5 == 0 ){
                    System.out.println(vector[i] +" es multipo de 2,3,5");
                }
            }
        }
}

