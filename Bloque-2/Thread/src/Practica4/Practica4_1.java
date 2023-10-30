package Practica4;

import java.util.*;

import static Practica4.Practica4_1.f;

class Acumula {
    double suma;

    public Acumula () {
        this.suma = 0.0;
    }

    synchronized void acumulaDato ( double dato ) {
        this.suma +=  dato;
    }

    synchronized double dameDato() {
        return this.suma;
    }
}

class MiHebra extends Thread {
    int 	miId, numHebras;
    long 	numRectangulos;
    Acumula a;

    public MiHebra ( int miId, int numHebras, long numRectangulos, Acumula a) {
        this.miId = miId;
        this.numHebras = numHebras;
        this.numRectangulos = numRectangulos;
        this.a = a;
    }

    public void run() {
        double baseRectangulo = 1.0 / ((double ) numRectangulos );
        double suma = 0.0;
        for ( long i = miId; i < numRectangulos; i+=numHebras ) {
            double x= baseRectangulo * ((( double ) i ) + 0.5 );
            suma += f( x );
        }

        a.acumulaDato(suma);

    }
}




public class Practica4_1 {

    public static void main ( String args[] ) throws InterruptedException {
        long 	numRectangulos;
        double 	baseRectangulo, x, suma, pi;
        int numHebras=8;
        long 	t1, t2;
        double 	tSec, tPar;


        try {
            numRectangulos = 1000000000;
            // numHebras = Integer.parseInt( args [ 1 ] );
        } catch ( NumberFormatException ex ) {
            numRectangulos = -1;
            // numHebras = -1;
            System.out.println ( "Error: Numeros de entrada incorrectos " );
            System.exit ( -1 );
        }

        System.out.println ();
        System.out.println ( "Calculo del numero PI mediante integracion " );

        //Calculo del número PI de forma secuencial
        System.out.println();
        System.out.println( "Comienzo del calculo secuencial" );
        t1 = System.nanoTime();
        baseRectangulo = 1.0 / ((double ) numRectangulos );
        suma 	       = 0.0;
        for ( long i = 0; i < numRectangulos; i++ ) {
            x= baseRectangulo * ((( double ) i ) + 0.5 );
            suma += f( x );
        }

        pi = baseRectangulo * suma;
        t2 = System.nanoTime();
        tSec = (( double ) ( t2 - t1 ) ) / 1.0e9;
        System.out.println ( "Version Secuencial. Numero PI:" + pi );
        System.out.println ( "Tiempo transcurrido (s.):     " + tSec );



        //Calculo del número PI de forma secuencial
        System.out.println();
        System.out.println( "Comienzo del calculo ciclico " );
        t1 = System.nanoTime();
        MiHebra hebra[] = new MiHebra[numHebras];
        Acumula acumula = new Acumula();


        for (int i = 0;i<hebra.length;i++){
            MiHebra hebra1 = new MiHebra(i,numHebras,numRectangulos,acumula);
            hebra1.start();
            hebra[i]=hebra1;
        }

        for (MiHebra hebra1 :hebra){
            hebra1.join();
        }

        pi = baseRectangulo * acumula.dameDato();
        t2 = System.nanoTime();
        tSec = (( double ) ( t2 - t1 ) ) / 1.0e9;
        System.out.println ( "Version Secuencial. Numero PI:" + pi );
        System.out.println ( "Tiempo transcurrido (s.):     " + tSec );

        System.out.println();
        System.out.println( "Fin de programa " );
    }

    static double f( double x ) {
        return ( 4.0/ (1.0 + x*x ) );
    }

}