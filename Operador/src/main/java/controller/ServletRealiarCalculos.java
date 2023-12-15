package controller;


import com.example.operador.HelloServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestorOperador;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletRealiarCalculos",value = "/ServletRealiarCalculos-servlet")
public class ServletRealiarCalculos  extends HttpServlet {
    private GestorOperador gestorOperador;

    public void init() {
        gestorOperador = new GestorOperador();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Operaciones a realizar...</h1>");

        // Formulario para ingresar números
        out.println("<form method=\"post\" action=\"TuServlet\">");
        out.println("Primer Numero: <input type=\"text\" name=\"num1\"><br>");
        out.println("Segundo Numero: <input type=\"text\" name=\"num2\"><br>");

        // Caja de selección para operaciones
        out.println("Operación: <select name=\"operacion\">");
        out.println("<option value=\"+\">Sumar</option>");
        out.println("<option value=\"-\">Restar</option>");
        out.println("<option value=\"*\">Multiplicar</option>");
        out.println("<option value=\"/\">Dividir</option>");
        out.println("<option value=\"modulo\">Modulo</option>");
        out.println("<option value=\"exponencial\">Exponencial</option>");
        out.println("</select><br>");

        // Botones Enviar y Borrar
        out.println("<input type=\"submit\" value=\"Enviar Datos\">");
        out.println("<input type=\"reset\" value=\"Borrar Datos\">");
        out.println("</form>");

        out.println("</body></html>");

    }
    public void destroy() {
    }
}
