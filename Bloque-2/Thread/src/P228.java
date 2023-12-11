public class P228 {
    public static void main(String args[]) {
        int numHebras;
        long vectorNumeros[] = {
                200000033L,4L,4L,4L,4L,4L,4L,4L,
                200000039L,4L,4L,4L,4L,4L,4L,4L,
                200000051L,4L,4L,4L,4L,4L,4L,4L,
                200000069L,4L,4L,4L,4L,4L,4L,4L,
                200000081L,4L,4L,4L,4L,4L,4L,4L,
                200000083L,4L,4L,4L,4L,4L,4L,4L,
                200000089L,4L,4L,4L,4L,4L,4L,4L,
                200000093L,4L,4L,4L,4L,4L,4L,4L

        };


        numHebras = 4;

        implementacionSecuencial(vectorNumeros);

        implementacionCiclica(vectorNumeros, numHebras);

        implementacionBloques(vectorNumeros, numHebras);


    }

    static void implementacionSecuencial(long[] vectorNumeros) {
        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación secuencial.");

        t1 = System.nanoTime();
        for (long vector : vectorNumeros){
            if (esPrimo(vector)){
                System.out.println(vector);
            }
        }
        t2 = System.nanoTime();
        tt = ((double) (t2 - t1)) / 1.0e9;

        System.out.println("Tiempo secuencial (seg.):\t\t\t" + tt);
    }

    static void implementacionCiclica(long[] vectorNumeros, int numHebras) {
        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación cíclica.");

        MiHebraCiclica3 v[] = new MiHebraCiclica3[numHebras];

        t1 = System.nanoTime();

        for (int i = 0; i < numHebras; i++) {
            v[i] = new MiHebraCiclica3(i, numHebras, vectorNumeros);
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


//------------------------------------------------------------------------------------------------------------

    static void implementacionBloques(long[] vectorNumeros, int numHebras) {

        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación por bloques.");

        MiHebraBloques3 v[] = new MiHebraBloques3[numHebras];

        t1 = System.nanoTime();

        for (int i = 0; i < numHebras; i++) {
            v[i] = new MiHebraBloques3(i, numHebras, vectorNumeros);
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

        System.out.println("Tiempo Bloques (seg.):\t\t\t" + tt);
    }

    static boolean esPrimo( long num ) {
        boolean primo;
        if( num < 2 ) {
            primo = false;
        } else {
            primo = true;
            long i = 2;
            while( ( i < num )&&( primo ) ) {
                primo = ( num % i != 0 );
                i++;
            }
        }
        return( primo );
    }
}


class MiHebraCiclica3 extends Thread {
    private int idHebra;
    private int numHebra;
    private long vector[];

    public MiHebraCiclica3(int i,int numHebras,long vector[] ){
        this.idHebra = i;
        this.numHebra = numHebras;
        this.vector = vector;
    }

    public void run(){

        for (int i = idHebra;i < vector.length;i+=numHebra){
            if (P226.esPrimo(vector[i])){
                System.out.println(vector[i]);
            }
        }


    }

}

class MiHebraBloques3 extends Thread {
    private int idHebra;
    private int numHebra;
    private long vector[];

    public MiHebraBloques3(int i,int numHebras,long vector[] ){
        this.idHebra = i;
        this.numHebra = numHebras;
        this.vector = vector;
    }

    public void run(){
        int i = 0;
        int Tam = (vector.length + numHebra-1)/numHebra;
        int ini= idHebra * Tam;
        int fin = Math.min(vector.length,(idHebra+1)*Tam);
        for (i = ini;i<fin;i++){
            if (P226.esPrimo(vector[i])){
                System.out.println(vector[i]);
            }
        }
    }
}
