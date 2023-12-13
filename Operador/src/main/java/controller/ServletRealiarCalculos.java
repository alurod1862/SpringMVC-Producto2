package controller;


import com.example.operador.HelloServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.GestorOperador;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletRealiarCalculos",value = "ServletRealiarCalculos-servlet")
public class ServletRealiarCalculos  extends HttpServlet {


    private GestorOperador gestorOperador;

    public void init() {
        gestorOperador = new GestorOperador();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        //head
        out.println("<html>" +
                "<head>" +
                "<title>Tienda Discos</title>" +
                "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>" +
                "</head>" +
                "<body>");
        //plantilla
        out.println("<div class='container'>" +
                "<div class='row justify-content-md-center'>" +
                "<div class='col-md-auto'>");
        //cuerpo
        out.println("<h1>Buscar Grupo</h1>");
        out.println("<ul class='list-group'>");

        /*String[] operador = gestorOperador.listaDeOperaciones();
        for(int i = 0; i < operador.length; i++){
            out.println("<li class='list-group-item'>"+operador[i]+"</li>");
        }*/

        out.println("</ul>");
        out.println("<br/>");
        out.println("<a class='btn btn-primary' href='index.html'>Volver</a>");
        //fin del cuerpo
        //cierre
        out.println("</div></div></div></body></html>");

    }
}
