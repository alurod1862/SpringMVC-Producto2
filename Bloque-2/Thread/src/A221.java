public class A221 {


    int numServicios = 0;

   synchronized void incrementaNumServicios(){
       numServicios++;
   }


   int dameNumServicios(){
       return numServicios;
   }

}
