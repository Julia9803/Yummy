package edu.nju.yummy.servlets;

import edu.nju.yummy.dao.UserRepository;
import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.User;
import edu.nju.yummy.service.impl.UserServiceBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Autowired
    UserServiceBean userServiceBean;
    @Autowired
    UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String phoneNumber = req.getParameter("phoneNumber");
        String password = req.getParameter("password");
        Message message = userServiceBean.login(phoneNumber,password);
        ServletContext context = getServletContext();
        String res = null;

        if(message.equals(Message.NOTFOUND)) {
            res = "抱歉，此电话号码未注册！";
        } else if(message.equals(Message.FAIL)) {
            res = "抱歉，用户名或密码错误！";
        }else if(message.equals(Message.SUCCESS)) {
            User user = userRepository.findByPhoneNumber(phoneNumber);
            context.setAttribute("username",user.getName());
            context.getRequestDispatcher("/index").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}
