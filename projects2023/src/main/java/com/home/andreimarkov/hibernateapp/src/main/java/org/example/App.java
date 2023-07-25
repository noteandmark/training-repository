package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Item item = session.get(Item.class,6);
//            Person person = item.getOwner();
//
//            System.out.println(person);
//            session.getTransaction().commit();
//            ---

//            Person person = session.get(Person.class,2);
//            Item newItem = new Item("Item from Hibernate", person);
//            person.getItems().add(newItem);
//            session.save(newItem);
//            ---

//            Person person = new Person("Test person", 30);
//            Item newItem = new Item("New item", person);
//
//            person.setItems(new ArrayList<Item>(Collections.singletonList(newItem)));
//            session.save(person);
//            session.save(newItem);
//            ---

//            Person person = session.get(Person.class,3);
//            List<Item> items = person.getItems();
//
//            //порождает SQL запрос
//            for (Item item: items) {
//                session.remove(item);
//            }
//
//            //не порождает SQL, но необходимо, чтобы в кэше все было верно
//            person.getItems().clear();
//            ---

//            Person person = session.get(Person.class,2);
//            //SQL
//            session.remove(person);
//            //чтобы было правильное состояние Hibernate кэша
//            person.getItems().forEach(i -> i.setOwner(null));

            Person person = session.get(Person.class,3);
            Item item = session.get(Item.class, 10);

            //для кэша Hibernate
            item.getOwner().getItems().remove(item);
            //порождает SQL запрос
            item.setOwner(person);
            //для кэша Hibernate
            person.getItems().add(item);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();

        }
    }

}
