/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.modelo.GestorVacunas_gChui;
import com.emergentes.modelo.Vacunas_gChui;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrea
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Vacunas_gChui objVacuna = new Vacunas_gChui();
        int id, pos;
        
        String op=request.getParameter("op");
        
        if(op.equals("nuevo"))
        {
            HttpSession ses = request.getSession();
            GestorVacunas_gChui vacun =(GestorVacunas_gChui) ses.getAttribute("vacun");
            objVacuna.setId(vacun.obtieneId());
            request.setAttribute("op", op);
            request.setAttribute("miVacuna", objVacuna);
            request.getRequestDispatcher("editar.jsp").forward(request, response);    
        }
        
        if(op.equals("modificar"))
        {
            id=Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorVacunas_gChui vacun =(GestorVacunas_gChui) ses.getAttribute("vacun");
            pos=vacun.ubicarProducto(id);
            objVacuna = vacun.getLista().get(pos);
            
            request.setAttribute("op", op);
            request.setAttribute("miVacuna", objVacuna);
            request.getRequestDispatcher("editar.jsp").forward(request, response);  
        }

        if(op.equals("eliminar"))
        {
            id=Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorVacunas_gChui vacun =(GestorVacunas_gChui) ses.getAttribute("vacun");
            pos=vacun.ubicarProducto(id);
            vacun.eliminarVacuna(pos);
            ses.setAttribute("vacun", vacun);
            response.sendRedirect("index.jsp");

        } 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Vacunas_gChui objVacuna = new Vacunas_gChui();
        int pos;
        String op=request.getParameter("op");
        
        if(op.equals("grabar"))
        {
            objVacuna.setId(Integer.parseInt(request.getParameter("id")));
            objVacuna.setNombre(request.getParameter("nombre"));
            objVacuna.setPeso(Double.parseDouble(request.getParameter("peso")));
            objVacuna.setTalla(Integer.parseInt(request.getParameter("talla")));
            objVacuna.setVacuna(request.getParameter("vacuna"));
            
            HttpSession ses = request.getSession();
            GestorVacunas_gChui vacun =(GestorVacunas_gChui) ses.getAttribute("vacun");
            
            String opg = request.getParameter("opg");
            if(opg.equals("nuevo"))
            {
                vacun.insertarVacuna(objVacuna);
            }
            else
            {
                pos=vacun.ubicarProducto(objVacuna.getId());
                vacun.modificarVacuna(pos, objVacuna);
            }
            ses.setAttribute("vacun", vacun);
            response.sendRedirect("index.jsp");       
        }    
        
    }

    

}
