
public class Examen1 {

    public int primoB;
    public static void main(String args[]) {
        int numHebras=8;
        long vector[] = { 1, 5, 10, 15, 20, 0, 14, 17, 18, 28, 38, 98, 99, 100,9000, 765, 768, 654, 6549, 123456, 98765, 45678934, 12, 134,
                123456, 876543, 987, 5678, 12456, 87654, 987654, 433494437, 780291637, 1405695061};


        numHebras = 4;

        implementacionSecuencial(vector);

        implementacionBloques(vector, numHebras);



    }

    static void implementacionSecuencial(long[] vector) {
        long t1;
        long t2;
        double tt;
        int primo = 0;
        int noPrimo = 0;

        System.out.println("");
        System.out.println("Implementación secuencial.");

        t1 = System.nanoTime();
        for (long vecto : vector){
            if (esPrimo(vecto)){
                primo+=1;
                System.out.println(vecto);
            }else{
                noPrimo+=1;
            }
        }
        t2 = System.nanoTime();
        tt = ((double) (t2 - t1)) / 1.0e9;

        System.out.println ( "Primos " + primo + "  No Primos: " + noPrimo );
        System.out.println("Tiempo secuencial (seg.):\t\t\t" + tt);
    }

    static void implementacionBloques(long[] vector, int numHebras) {
        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación por bloques.");

        MiHebraCiclica1 v[] = new MiHebraCiclica1[numHebras];

        t1 = System.nanoTime();

        for (int i = 0; i < numHebras; i++) {
            v[i] = new MiHebraCiclica1(i, numHebras, vector);
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

        //System.out.println ( "Pares: " + v. + "  Impares: " + v. );
        System.out.println("Tiempo cíclico (seg.):\t\t\t" + tt);
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


class MiHebraCiclica1 extends Thread {
    private int idHebra;
    private int numHebra;
    private long vector[];



    public MiHebraCiclica1(int i,int numHebras,long vector[] ){
        this.idHebra = i;
        this.numHebra = numHebras;
        this.vector = vector;
    }

    public void run(){

        for (int i = idHebra;i < vector.length;i+=numHebra){
            if (Examen1.esPrimo(vector[i])){
                System.out.println(vector[i]);
            }
        }
    }


}

