package org.example2;

import org.example2.model.Person;
import org.example2.model.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person person = new Person("Test person", 50);
//            Passport passport = new Passport( 123456);
//
//            person.setPassport(passport);
//
//            session.save(person);
//            ---

//            Person person = session.get(Person.class,1);
//            System.out.println(person.getPassport().getPassportNumber());
//            ---

//            Passport passport = session.get(Passport.class,1);
//            System.out.println(passport.getPerson().getName());
//            ---

//            Person person = session.get(Person.class,1);
//            person.getPassport().setPassportNumber(654321);
//            System.out.println(person.getPassport().getPassportNumber());
//            ---

            Person person = session.get(Person.class,1);
            session.remove(person);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
