package com.emergentes.controlador;
import com.emergentes.dao.AvisoDAO;
import com.emergentes.dao.AvisoDAOi;
import com.emergentes.modelo.Aviso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            AvisoDAO dao = new AvisoDAOi();           
            int id;           
            Aviso avi = new Aviso();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"): "view";
            switch (action){
                case "add":
                    
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                    break;
                case "edit":
                    
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                    break;
                case "delete":
                    
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    
                    response.sendRedirect("Controller");
                    break;
                default:
                    
                    List<Aviso> lista = dao.getAll();
                    request.setAttribute("avisos", lista);
                    request.getRequestDispatcher("listado.jsp").forward(request, response);
                    break;
            }         
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        AvisoDAO dao = new AvisoDAOi();
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String exposicion = request.getParameter("exposicion");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        Aviso avi = new Aviso();        
        avi.setId(id);
        avi.setTitulo(titulo);
        avi.setExposicion(exposicion);
        avi.setFecha(fecha);
        avi.setHora(hora);
        avi.setCupo(cupo); 
        if(id == 0){
            try{
                dao.insert(avi);
                response.sendRedirect("Controller");
            }catch(Exception e){
                System.out.println("Error " + e.getMessage());
            }
        }
        else{
            try{
                    dao.update(avi);
                    response.sendRedirect("Controller");
                }catch (Exception e){
                    System.out.println("Error " + e.getMessage());
                }
        }            
    }
}
