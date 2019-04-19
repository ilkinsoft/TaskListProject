package com.wap;

import com.wap.model.Task;
import com.wap.model.Team;
import com.wap.model.Userr;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionSingleton {

    private static final SessionFactory ourSessionFactory;
    private static Session session;

    private SessionSingleton() {
    }

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Task.class);
            configuration.addAnnotatedClass(Team.class);
            configuration.addAnnotatedClass(Userr.class);

            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {

        if (session != null && session.isConnected()) return session;


        session = ourSessionFactory.openSession();
        return session;
    }
}
