package perv.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import perv.bean.Customer;

import java.util.ArrayList;
import java.util.List;

import perv.bean.HibernateUtil;

public class CustomerDao {
    /**
     * 查询所有customer
     * @return
     */
    public List<Customer> findAll()
    {
        //QBC查询
        Session session = HibernateUtil.openSession();
        Transaction tr = session.beginTransaction();
        //查询
        Criteria criteria = session.createCriteria(Customer.class);
        //查询结果
        List<Customer> list = criteria.list();
        //提交
        tr.commit();
        session.close();
        return list;
    }
}
