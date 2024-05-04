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
			System.out.println("*******Accessing Employee*********");
			Employee employee = entityManager.find(Employee.class, 1);

			System.out.println("*******Accessing AccessCard*********");
			System.out.println(employee.getCard());

			AccessCard card = entityManager.find(AccessCard.class, 1);
			System.out.println(card);

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
