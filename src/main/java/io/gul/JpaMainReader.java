package io.gul;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class JpaMainReader {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = PersistenceManager.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
//			System.out.println("*******Accessing Employee*********");
//			Employee employee = entityManager.find(Employee.class, 1);
//			System.out.println("Employee AccessCard*****: ");
//			System.out.println(employee.getCard());

//			System.out.println("*******Accessing AccessCard*********");
//			AccessCard card = entityManager.find(AccessCard.class, 1);
//
//			System.out.println("AccessCard'sEmployee*****: ");
//			System.out.println(card.getOwner());

			System.out.println("*******Accessing PayStub*********");
			PayStub card = entityManager.find(PayStub.class, 1);
			System.out.println("*******Accessing PayStub Employee*********");
			System.out.println(card.getEmp());
		}finally {
			if(entityManager.isOpen()){
				entityManager.close();
			}
			if (entityManagerFactory.isOpen()){
				entityManagerFactory.close();
			}
		}
	}
}
