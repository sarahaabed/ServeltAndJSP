/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.MyProduct;
import dbaccess.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SAWSAN
 */
public class Home extends HttpServlet {

    ProductDAO products;
    String Category;
    ArrayList<MyProduct> prods;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Category = request.getParameter("category");
        System.out.println(Category);
        ProductDAO products = new ProductDAO();
        if (Category!=null) {
            prods =products.retrieveCategoryProducts(Category);
        }
        else 
        {
            prods = products.retrieveCategoryProducts("sports");
        }
        request.setAttribute("categoryProds", prods);
        //response.sendRedirect("index");
        RequestDispatcher rd = request.getRequestDispatcher("index");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String getPriceSearch=request.getParameter("searchPrice");
        double priceValue = Double.parseDouble(getPriceSearch);
         System.out.println(priceValue);
        ProductDAO products = new ProductDAO();
        if (priceValue>0) {
            prods =products.retrievePriceProducts(priceValue);
        }
    
        request.setAttribute("categoryProds", prods);
        //response.sendRedirect("index");
        RequestDispatcher rd = request.getRequestDispatcher("index");
        rd.forward(request, response); 
    

        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
