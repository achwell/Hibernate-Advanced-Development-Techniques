package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateUserStudentInstructorDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session

        try (factory; Session session = factory.getCurrentSession()) {
            //create the objects
            User student = new Student("John", "Doe", "john@luv2code.com", "HIBERNATE");
            User instructor = new Instructor("Mary", "Public", "mary@luv2code.com", 20000.00);

            //start a transaction
            session.beginTransaction();

            //save the object
            System.out.println("Saving the users..");
            session.persist(student);
            session.persist(instructor);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
    }
}
