package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Address;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentAddressDemo {

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
            Address homeAddress = new Address("Briggen 1", "Drammen", "3038");
            Address billingAddress = new Address("Kontorgata 1", "Byen", "666");
            tempStudent.setHomeAddress(homeAddress);
            tempStudent.setBillingAddress(billingAddress);

            //start a transaction
            session.beginTransaction();

            //save the object
            System.out.println("Saving the student and address..");
            session.persist(tempStudent);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
    }
}
