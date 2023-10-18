
class A231 extends Thread {
    int miId, numHebras;
    double vector [];
    Acumula a;
    public A231 ( int miId, int numHebras, double vector [ ], Acumula a ) {
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
class Acumula {
    double suma = 0.0;
    void acumulaValor ( double valor ) {
        this.suma += valor;
    }
    double dameResultado() {
        return this.suma;
    }
    public static void main(String[] args) {

        double vector[] = {
                1,2,3,4,5,6,7,8,9,10,
                11,12,13,14,15,16,17,18,19,20
        };

        Acumula a = new Acumula();


        int tamaño= vector.length;

        for (int i = 0 ;i<tamaño;i++){
            a.acumulaValor(vector[i]);
            System.out.println(a.dameResultado());
        }

    }
}