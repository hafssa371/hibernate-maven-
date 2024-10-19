package util;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {


        private static final SessionFactory sessionFactory;

        static {
            try {
                // Créer la SessionFactory à partir du fichier de configuration standard (hibernate.cfg.xml)
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                // Log de l'exception
                System.err.println("La création initiale de la SessionFactory a échoué." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }

