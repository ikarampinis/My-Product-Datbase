package com.example.web;

import com.example.model.ProductCheck;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class SelectProduct extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String product_barcode = request.getParameter("barcode");
        String product_name = request.getParameter("name");
        String product_color = request.getParameter("color");
        String product_description = request.getParameter("description");
        
        ProductCheck product = new ProductCheck();
        boolean result = product.EnterDatabase(product_barcode, product_name, product_color, product_description);
        
        List list = new ArrayList();
        if(result){
            list.add(product_barcode);
            list.add(product_name);
            list.add(product_color);
            list.add(product_description);
        }
        request.setAttribute("characteristics", list);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}
