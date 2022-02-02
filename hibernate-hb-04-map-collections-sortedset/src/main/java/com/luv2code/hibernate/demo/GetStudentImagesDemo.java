package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class GetStudentImagesDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session

        try (factory; Session session = factory.getCurrentSession()) {

            //start a transaction
            session.beginTransaction();

            //get the student by id
            int theId = 1;
            Student student = session.get(Student.class, theId);

            // print the student details
            System.out.println(student);
            // print the images
            System.out.println(student.getImages());
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
    }
}
