package perv.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final Configuration cfg;
    private static final SessionFactory factory;
    static
    {
        //加载配置文件
        cfg = new Configuration().configure();
        //生成factory对象
        factory = cfg.buildSessionFactory();
    }
    public static Session openSession()
    {
        return factory.openSession();
    }
}
