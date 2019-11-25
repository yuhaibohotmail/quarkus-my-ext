package io.quarkus.my.ext;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class HelloWorldServlet extends HttpServlet {

    public HelloWorldServlet() {
        System.out.println("HelloWorldServlet()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().print("Hello from my simple Quarkus extension");
    }

}
