package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/test")
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

   /* @PersistenceUnit
    private EntityManagerFactory emf;
    
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
    	EntityManager em = emf.createEntityManager();
        response.setContentType("text/html;charset=UTF-8");
        final PrintWriter writer=response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html><body>");
        writer.println("Connected: " + em.isOpen());
        writer.println("</body></html>");
        em.close();
    }
   */
   @Resource
    private DataSource ds;
    
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            
        final PrintWriter writer = response.getWriter();
        response.setContentType(
                "text/html;charset=UTF-8");
            writer.println("<!DOCTYPE html>");
            writer.println("<html><body>");
        try(final Connection con = ds.getConnection()) {
            if(con.isValid(10)) {
                writer.println("<BR>Connected!");
            }
        } catch (Exception ex) {
            writer.println(ex.getMessage());
        }
        writer.println(
        "<BR>Test finished!</body></html>");
    }
}
