package company;

import javax.servlet.ServletException;
import java.io.IOException;

public class Main extends javax.servlet.http.HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();

        System.out.println("gas gas gas");
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("gas");
    }
}
