public class RepartoBloques {



    public static int procesos = 17;
    public static int Nhebras=4;
    public static int i=0;
    public static int hebra=3;


    public static void RepartoBloquesHebra(){
        System.out.println("_______________________________________________________");
        System.out.println("Hebra " + hebra);

        int Tam = (procesos + Nhebras-1)/Nhebras;
        int ini= hebra * Tam;
        int fin = Math.min(procesos,(hebra+1)*Tam);
        for (i = ini;i<fin;i++){
            System.out.println(i);
        }


    }

    public static void main(String[] args) {

        RepartoBloquesHebra();

    }


}
