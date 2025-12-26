// package com.example.demo.servlet;

// import java.io.IOException;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/hello")
// public class HelloServlet extends HttpServlet {

//     @Override
//     public void doGet(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {

//         response.setContentType("text/plain");
//         response.getWriter().write("Hello Servlet");
//     }
// }


package com.example.demo.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Matches test: testServletContentTypeIsPlainText 
        response.setContentType("text/plain"); 
        
        // Matches test: testServletRespondsWithHelloMessage 
        // The test looks for the specific substring "Hello from HelloServlet"
        response.getWriter().write("Hello from HelloServlet"); 
    }
}