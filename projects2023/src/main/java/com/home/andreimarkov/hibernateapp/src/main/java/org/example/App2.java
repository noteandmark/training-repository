package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App2 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class,1);

//            Hibernate.initialize(person.getItems());//подгружаем ленивые сущности

            session.getTransaction().commit();

            //после подгрузки можем использовать вне сессии
//            System.out.println(person.getItems());

            System.out.println("Сессия завершилась");

            //открываем сессию и транзакцию еще раз (можем в любом месте в коде делать)
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Находимся внутри второй транзакции");

            person = (Person) session.merge(person);
            Hibernate.initialize(person.getItems());

            //или можно еще так подгрузить, второй способ, с HQL запросом:
//            List<Item> items = session.createQuery("select i from item i where i.owner.id=:personId",
//                    Item.class)
//                    .setParameter("personId",person.getId()).getResultList();
            //p.s.можно убрать строку session.merge - не пристегиваем сущность с новой сущностью,
            //т.к. выполняем HQL запрос


            session.getTransaction().commit();

            System.out.println("Вне второй сессии");

            //это работает, так как связанные товары были загружены
            System.out.println(person.getItems());

        } finally {
            sessionFactory.close();

        }
    }

}
