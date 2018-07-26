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
            //create student obj

            //start transaction
            session.beginTransaction();
            //save student obj

            //commit transaction
            session.getTransaction().commit();
            System.out.println("work done: DAO saved to db.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
