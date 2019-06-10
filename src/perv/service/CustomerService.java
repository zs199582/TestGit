package perv.service;

import perv.bean.Customer;
import perv.dao.CustomerDao;

import java.util.List;

public class CustomerService {
    public List<Customer> finkAll()
    {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.findAll();
    }
}
