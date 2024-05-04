package io.gul;

import io.gul.entities.PayStub;
import io.gul.persistence.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class JpaMainDeleter {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = PersistenceManager.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		//Employee employee = entityManager.find(Employee.class, 2);
		PayStub payStub = entityManager.find(PayStub.class, 3);

		try {
			transaction.begin();
			//entityManager.remove(employee);
			entityManager.remove(payStub);

			transaction.commit();
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
			if (entityManagerFactory.isOpen()) {
				entityManagerFactory.close();
			}
		}
	}
}
