package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static com.luv2code.hibernate.demo.entity.Status.ACTIVE;
import static com.luv2code.hibernate.demo.entity.Status.INACTIVE;

public class CreateStudentDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session

        try (factory; Session session = factory.getCurrentSession()) {
            //create the object
            Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com", ACTIVE);
            Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com", INACTIVE);

            //start a transaction
            session.beginTransaction();

            //save the object
            System.out.println("Saving the students..");
            session.persist(tempStudent1);
            session.persist(tempStudent2);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
    }
}
