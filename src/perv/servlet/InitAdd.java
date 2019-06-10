package perv.servlet;

import perv.bean.Customer;
import perv.service.CustomerService;
import sun.misc.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 初始化到添加联系人的页面
 */
public class InitAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();
        List<Customer> customers = customerService.finkAll();

        req.setAttribute("list",customers);
        req.getRequestDispatcher("/jsp/linkman/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
