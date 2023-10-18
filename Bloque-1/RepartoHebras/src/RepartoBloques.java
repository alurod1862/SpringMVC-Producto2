public class RepartoBloques {



    public static int procesos = 17;
    public static int Nhebras=5;
    public static int diferencia=procesos/Nhebras;
    public static int i=0;
    public static int hebra=1;

    public static int a ;

    public static void RepartoBloquesHebras(){
        for (int e =0;e<Nhebras;e++){
            System.out.println("_______________________________________________________");
            System.out.println("Hebra " + e + "\n");
            for (;i<diferencia;i++) {
                System.out.println(i);
            }
            diferencia=diferencia+4;
        }
    }

    public static void RepartoBloquesHebra(){
        i=hebra*6;
        diferencia=i+6;
        System.out.println("_______________________________________________________");
        System.out.println("Hebra " + hebra + "\n");
        for (;i<diferencia;i++) {
            System.out.println(i);
        }
    }


    public static void main(String[] args) {

        RepartoBloquesHebras();

    }


}
