package org.example3;

import org.example3.model.Actor;
import org.example3.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //try with resources
        try (sessionFactory){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Movie movie = new Movie("Pulp fiction", 1994);
//            Actor actor1 = new Actor("Harvey Keitel",81);
//            Actor actor2 = new Actor("Samuel L. Jackson",72);
//
//            //аналог Arrays.asList()
//            movie.setActors(new ArrayList<>(List.of(actor1,actor2)));
//
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.save(movie);
//
//            session.save(actor1);
//            session.save(actor2);
//            ---

//            Movie movie = session.get(Movie.class,1);
//            System.out.println(movie.getActors());
//            ---

//            Movie movie = new Movie("Reservoir Dogs", 1992);
//            Actor actor = session.get(Actor.class,1);
//
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//
//            session.save(movie);
//            ---

            Actor actor = session.get(Actor.class,2);
            System.out.println(actor.getMovies());

            Movie movietoRemove = actor.getMovies().get(0);

            actor.getMovies().remove(0);
            movietoRemove.getActors().remove(actor);

            session.getTransaction().commit();
        }
    }
}