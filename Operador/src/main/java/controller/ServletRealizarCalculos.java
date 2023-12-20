package controller;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestorOperador;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletRealiarCalculos",value = "/ServletRealiarCalculos-servlet")
public class ServletRealizarCalculos extends HttpServlet {
    private GestorOperador gestorOperador;

    public void init() {
        gestorOperador = new GestorOperador();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();



        String numero1 = request.getParameter("num1");
        String numero2 = request.getParameter("num2");
        String operacion = request.getParameter("operacion");
        String result = gestorOperador.calculaRdo(operacion,numero1,numero2);


        out.println("El resultado es " + result);

        out.println("<a class='btn btn-primary' href='calculo.html'>Volver</a>");




    }
    public void destroy() {
    }
}
