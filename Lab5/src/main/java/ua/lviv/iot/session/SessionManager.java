package ua.lviv.iot.session;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {
    private static final SessionFactory OUR_SESSION_FACTORY;

    static {
        try {
            OUR_SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        } catch (Throwable th) {
            System.err.println("Initial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    public static Session getSession() throws HibernateException {
        return OUR_SESSION_FACTORY.openSession();
    }
}
