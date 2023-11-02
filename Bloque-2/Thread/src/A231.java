import java.util.concurrent.atomic.AtomicInteger;

public class  A231 {

    public static void main(String[] args) {


        int vectores = 10000000;

        double [] vector = new double[vectores];

        for (int i =0;i < vectores;i++){
            vector[i] = i;
        }

        hebraPocha(vector);
        hebraBuena(vector);
    }

    private static void hebraPocha(double []vector) {
        long   t1, t2;
        double tt;
        int    numHebras;


        numHebras = 4;


        Mihebra v[] = new Mihebra [ numHebras ];
        Acumula a = new Acumula();
        t1 = System.nanoTime();

        for ( int i = 0; i < numHebras; i++ ) {
            v[ i ] = new Mihebra (i,numHebras,vector,a);
            v[ i ].start();
        }

        for ( int i = 0; i < numHebras; i++ ) {
            try {
                v[ i ].join();
            } catch ( InterruptedException ex ) {
                ex.printStackTrace();
            }
        }

        t2 = System.nanoTime();
        tt = ( ( double ) ( t2 -t1 ) ) / 1.0e9;
        //System.out.println ( "Total de incrementos: " + c.dameNumIncrementos() );
        System.out.println ( "Tiempo Transcurrido en segs.:" + tt + " hebra mala");
        System.out.println();
    }

    private static void hebraBuena(double []vector) {
        long   t1, t2;
        double tt;
        int    numHebras;


        numHebras = 4;


        Mihebra2 v[] = new Mihebra2 [ numHebras ];
        Acumula a = new Acumula();
        t1 = System.nanoTime();

        for ( int i = 0; i < numHebras; i++ ) {
            v[ i ] = new Mihebra2 (i,numHebras,vector,a);
            v[ i ].start();
        }

        for ( int i = 0; i < numHebras; i++ ) {
            try {
                v[ i ].join();
            } catch ( InterruptedException ex ) {
                ex.printStackTrace();
            }
        }

        t2 = System.nanoTime();
        tt = ( ( double ) ( t2 -t1 ) ) / 1.0e9;
        //System.out.println ( "Total de incrementos: " + c.dameNumIncrementos() );
        System.out.println ( "Tiempo Transcurrido en segs.:" + tt + " hebra buena" );
        System.out.println();
    }

}

class Mihebra extends Thread {
    int miId, numHebras;
    double vector [ ];
    Acumula a;
    public Mihebra ( int miId, int numHebras, double vector [ ], Acumula a ) {
        this.miId = miId;
        this.numHebras = numHebras;
        this.vector = vector;
        this.a = a;
    }
    public void run () {

        for ( int i = miId; i < vector.length; i += numHebras ) {
            a.acumulaValor ( vector [ i ] );
        }
    }

}

class Mihebra2 extends Thread {
    int miId, numHebras;
    double vector [ ];
    Acumula a;
    public Mihebra2 ( int miId, int numHebras, double vector [ ], Acumula a ) {
        this.miId = miId;
        this.numHebras = numHebras;
        this.vector = vector;
        this.a = a;
    }
    public void run () {


        double h = 0.0;

        for ( int i = miId; i < vector.length; i += numHebras ) {
            h += vector[i];
        }

        a.acumulaValor(h);
    }

}


class Acumula {

    Double suma = 0.0;
    synchronized void acumulaValor ( double valor ) {
        this.suma += valor;
    }
    synchronized double dameResultado() {
        return this.suma;
    }
}




