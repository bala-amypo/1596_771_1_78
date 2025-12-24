package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    private static final String MESSAGE = "Hello from HelloServlet";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Must NOT fail if request is null (Test #4)
        if (response == null) {
            return;
        }

        // Required by Test #2
        response.setContentType("text/plain");

        // Must allow exception to propagate (Test #5)
        PrintWriter writer = response.getWriter();

        // Deterministic output (Tests #1, #6, #7)
        writer.write(MESSAGE);
        writer.flush();
    }
}
