package com.newer.admin.admin.web.servlet;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.newer.admin.admin.domain.Admin;
import com.newer.admin.admin.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dl")
public class AdminServlet extends HttpServlet {

    private AdminService adminService=new AdminService();

    public AdminServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if ("adminlogin".equals(action)) {
            adminlogin(req, resp);


        }

    }



    private void adminlogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        String adminname = req.getParameter("adminname");
        String adminpwd = req.getParameter("adminpwd");
        Admin admin=adminService.find(adminname,adminpwd);
       if(admin == null) {
           out.print(0);
        }else {
           //session.setAttribute("admin", admin);
           out.print(1);
       }
        out.close();
    }

}

