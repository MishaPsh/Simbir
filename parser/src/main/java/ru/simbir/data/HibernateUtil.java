package ru.simbir.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.simbir.logics.Delimiter;

import java.util.Map;

public class HibernateUtil {
    Delimiter delimiter = new Delimiter();
    public void hibUtil() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(RecSQL.class).buildSessionFactory();
        try {
            for (Map.Entry<String, Integer> item : delimiter.map_text.entrySet()) {
                Session session = factory.getCurrentSession();
                String key = item.getKey();
                Integer val = item.getValue();
                RecSQL recsql = new RecSQL(key, val);
                session.beginTransaction();
                session.save(recsql);
                session.getTransaction().commit();
                factory.close();
            }
        } catch (
                HibernateException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
