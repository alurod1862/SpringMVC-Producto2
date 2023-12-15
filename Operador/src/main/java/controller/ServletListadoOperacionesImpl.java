package controller;


import modelo.GestorOperador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletListadoOperacionesImpl",value = "/ServletListadoOperacionesImpl-servlet")
public class ServletListadoOperacionesImpl extends HttpServlet {

    private GestorOperador gestorOperador;

    public void init() {
        gestorOperador = new GestorOperador();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<ul>");
        out.println("<li>Suma</li>");
        out.println("<li>Resta</li>");
        out.println("<li>Multiplicación</li>");
        out.println("<li>División</li>");
        out.println("</ul>");
        out.println("Volver a inicio");





    }
    public void destroy() {
    }

}
