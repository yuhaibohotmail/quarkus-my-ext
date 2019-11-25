package me.snowdrop.my.ext;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloServlet")
public class HelloWorldServlet extends HttpServlet {

    public static final String URL_PATTERN = "/helloServlet";

    public void init(ServletConfig config) {
        System.out.println("HelloWorldServlet initialized ...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("Hi from HelloWorld Servlet of the Quarkus extension");
    }
}
