package Examen;

/*
Debes implementar un programa para contar el número de elementos pares y el número de elementos impares que tiene un vector. Se te proporciona un esqueleto del programa para utilizar. Se ha empleado una clase auxiliar CuentaNumeros que puedes variar o adaptar.

1.- Implementa el programa secuencial y mide tiempos.

2.- Implementa el programa paralelo con una distribución cíclica , y aplicando el método de los dos pasos (Reducciones). Calcula tiempos.

3.-  Implementa el programa paralelo con una distribución cíclica , pero sin aplicar reducciones. Calcula tiempos.

4.- Qué programa funciona más óptimo, ¿por qué?
 */

public class CalculoParImpar_b {
    public static void main(String args[]) {
        int numHebras;

        long vector[] = {1, 5, 10, 15, 20, 0, 14, 17, 18, 28, 38, 98, 99, 100, 9000, 765, 768, 654, 6549, 123456, 98765, 45678934, 12, 134,
                123456, 876543, 987, 5678, 12456, 87654, 987654, 32153478, 433494437, 780291637, 1405695061,
                1, 5, 10, 15, 20, 0, 14, 17, 18, 28, 38, 98, 99, 100, 9000, 765, 768, 654, 6549,
                123456, 98765, 45678934, 12, 134};


        numHebras = 4;
        implementacionSecuencial(vector);

        //CuentaNumeros numeros = new CuentaNumeros();

        implementacionCiclica(vector, numHebras);

        implementacionCiclicaReduciones(vector,numHebras);

    }

    static void implementacionSecuencial(long[] vectorNumeros) {
        long t1;
        long t2;
        double tt;
        System.out.println("");
        System.out.println("Implementación secuencial.");
        System.out.println("Números pares e impares: ");

        int pares=0;
        int impares=0;
        t1 = System.nanoTime();
        //Escribe aquí la implementación secuencial
        for( int i = 0; i < vectorNumeros.length; i++ ) {
            if((vectorNumeros[i] % 2 == 0)) {
               pares++;
            }else{
                impares++;
            }
        }
        System.out.println();

        //Fin de la implementación secuencial
        t2 = System.nanoTime();
        tt = ((double) (t2 - t1)) / 1.0e9;

        System.out.println("Pares: " + pares );
        System.out.println("Impares: " + impares);
        System.out.println("Tiempo secuencial (seg.):\t\t\t" + tt);
    }

    static void implementacionCiclica(long[] vectorNumeros, int numHebras) {
        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación cíclica.");
        System.out.println("Numeros pares e impares ----- ");

        //Haz new de la hebra. //Como siempre.
        MiHebraCiclica v[] = new MiHebraCiclica[numHebras];


        t1 = System.nanoTime();

        //implementa la inicialización de hebras con vector. NO TE LIES EN ESTE APARTADO, es copiar la
        //que hacemos siempre.

        for (int i = 0; i < numHebras; i++) {
            v[i] = new MiHebraCiclica(i, numHebras, vectorNumeros);
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

        System.out.println("Pares : " );
        System.out.println("Impares : " );
        System.out.println("Tiempo cíclico (seg.):\t\t\t" + tt);
    }

    static Boolean CuentaNumeros(long num) {
        boolean par=true;
        if (num % 2 ==0 ){
            par=true;
        }else{
            par=false;
        }
        return par;

    }

    static void implementacionCiclicaReduciones(long[] vectorNumeros, int numHebras) {
        long t1;
        long t2;
        double tt;

        Acumula a = new Acumula();

        System.out.println("");
        System.out.println("Implementación cíclica.");
        System.out.println("Numeros pares e impares ----- ");

        //Haz new de la hebra. //Como siempre.
        MiHebraCiclicaReduciones v[] = new MiHebraCiclicaReduciones[numHebras];


        t1 = System.nanoTime();

        //implementa la inicialización de hebras con vector. NO TE LIES EN ESTE APARTADO, es copiar la
        //que hacemos siempre.

        for (int i = 0; i < numHebras; i++) {
            v[i] = new MiHebraCiclicaReduciones(i, numHebras, vectorNumeros,a);
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

        System.out.println("Pares : " );
        System.out.println("Impares : " );
        System.out.println("Tiempo cíclico (seg.):\t\t\t" + tt);
    }

}

class MiHebraCiclica extends Thread {
    private int idHebra;
    private int numHebra;
    private long vector[];

    public MiHebraCiclica(int i,int numHebras,long vector[] ){
        this.idHebra = i;
        this.numHebra = numHebras;
        this.vector = vector;
    }

    public void run(){

        int par=0;
        int impar=0;

        for (int i = idHebra;i < vector.length;i+=numHebra){
            if (CalculoParImpar_b.CuentaNumeros(this.vector[i])){
                par++;
            }else{
                impar++;
            }
        }

        System.out.println("Par" + par);
        System.out.println("Par" + impar);


    }
}




class MiHebraCiclicaReduciones extends Thread {
    private int idHebra;
    private int numHebra;
    private long vector[];

    Acumula a;

    public MiHebraCiclicaReduciones(int i,int numHebras,long vector[] ,Acumula a){
        this.idHebra = i;
        this.numHebra = numHebras;
        this.vector = vector;
        this.a = a;

    }

    public void run(){
        int apoyo = 0;

        for (int i = idHebra;i < vector.length;i+=numHebra){
            if (CalculoParImpar_b.CuentaNumeros(this.vector[i])){
                apoyo += vector[i];
            }
        }

        a.acumulaValor(apoyo);

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