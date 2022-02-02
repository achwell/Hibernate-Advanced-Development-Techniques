package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class CreateStudentImagesSetDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session

        try (factory; Session session = factory.getCurrentSession()) {
            //create the object
            Student tempStudent = new Student("John", "Doe", "john@luv2code.com");
            Set<String> theImages = tempStudent.getImages();
            theImages.add("photo1.jpg");
            theImages.add("photo2.jpg");
            theImages.add("photo3.jpg");
            theImages.add("photo4.jpg");
            theImages.add("photo4.jpg"); //Duplicate, filtered at java level by HashSet!!!
            theImages.add("photo5.jpg");
            theImages.add("photo5.jpg"); //Duplicate, filtered at java level by HashSet!!!

            //start a transaction
            session.beginTransaction();

            //save the object
            System.out.println("Saving the student and images..");
            session.persist(tempStudent);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
    }
}
