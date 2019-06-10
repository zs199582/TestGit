package perv.bean;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;
import org.w3c.dom.stylesheets.LinkStyle;
import sun.security.provider.ConfigFile;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test()
    {
        //配置
        Configuration config = new Configuration();

        config.configure();

        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tr = session.beginTransaction();

        //编写保存的代码
        Customer customer = new Customer();
        customer.setCust_name("测试");

        session.save(customer);
        //提交事务
        tr.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }

    /**
     * 查询
     */
    @org.junit.Test
    public void test2()
    {
        //唯一表示OID查询方式
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        //
        Customer customer = session.get(Customer.class,1L);
        System.out.println(customer);
        transaction.commit();
        session.close();
    }

    /**
     * 基于HQL语言的查询
     */
    @org.junit.Test
    public void test3()
    {
        Session session = HibernateUtil.openSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery("select new Customer(c.cust_name,c.cust_id) from Customer c where cust_name = ?");
        query.setParameter(0,"小明");
        List<Customer> list = query.list();
        for (Customer customer:list
             ) {
            System.out.println(customer.toString());
        }
        tr.commit();
        session.close();
    }
}
