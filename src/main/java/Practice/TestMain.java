package Practice;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestMain {

  public static void main(String[] args) {

    Test test = new Test();
    test.setName("abc");
    test.setNumber(1234567890);
    Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Mobile.class);

    SessionFactory factory = con.buildSessionFactory();

    Session session = factory.openSession();

    Transaction tx = session.beginTransaction();

    Query query=session.createQuery("from Mobile");
    List<Mobile> list=query.list();
    System.out.println(list);

    tx.commit();

    session.close();

    System.out.println("*************updated**********");
  }
}
