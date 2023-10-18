import java.lang.reflect.Array;

public class CreacionDeHebras {


    public static void main(String[] args) {



        Hebras1 h1 = new Hebras1();
        Hebras2 h2 = new Hebras2();

        h1.start();
        h2.start();


    }



}

class Hebras1 extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Soy la hebra 1 ");
        }
    }

}


class Hebras2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Soy la hebra 2");
        }
    }

}