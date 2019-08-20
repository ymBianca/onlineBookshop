package com.newer.user.web.servlet;

import com.google.gson.JsonObject;
import com.newer.user.domain.User;
import com.newer.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("login".equals(action)) {
            login(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String loginname = req.getParameter("loginname");
        String loginpass = req.getParameter("loginpass");
        HttpSession session = req.getSession();
        JsonObject jo = new JsonObject();
        User user = null;
        if ((user = userService.login(loginname, loginpass)) == null) {
            jo.addProperty("msg", "用户名或密码错误！");
        } else if (user.getStatus() == 0) {
            jo.addProperty("msg", "该账户被禁用，请与管理员联系！");
        } else {
            session.setAttribute("user", user);    //用户数据必须要放到session对象中
            jo.addProperty("suc", true);
        }
        System.out.println(user.getLoginname());
        PrintWriter out = resp.getWriter();
        out.print(jo);
        out.close();
    }


    @Override
    public void destroy() {
        userService.close();
    }

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }
}
