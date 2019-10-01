package org.TFG.project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class servlet1 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        ArrayList<Object> listOfFiles = new ArrayList();

        String path = request.getParameter("path");
        path.replaceAll("\"", "\\\\");
        File paramFile = new File(path);

        for (File file : paramFile.listFiles()) {
            listOfFiles.add(file);
        }

        request.setAttribute("curUrl", request.getRequestURL());
        request.setAttribute("listOfFiles", listOfFiles.toArray());
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}