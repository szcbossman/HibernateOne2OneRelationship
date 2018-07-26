package com.troyszc.firstHibernate;

import com.troyszc.firstHibernate.entity.Instructor;
import com.troyszc.firstHibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDAO {

    public static void main (String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        //use session obj to save java obj
        try {
            //create DAO obj
            Instructor theInstructor = new Instructor("Troy", "Song", "troysong33@gmail.com");
            InstructorDetail theDetail = new InstructorDetail("youtube/troyCCA", "Car Enthusiast");

            //associate the obj
            theInstructor.setInstructorDetail(theDetail);

            //start transaction
            session.beginTransaction();

            //save DAO obj
            session.save(theInstructor); //will also save theDetail due to cascade.all
            //commit transaction
            session.getTransaction().commit();
            System.out.println("work done: DAO saved to db.");
            System.out.println("DAO: \n" + theInstructor + "\n" + theDetail);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
