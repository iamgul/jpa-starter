package io.gul;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setId(1);
		e.setName("Gul");
		e.setDob(new Date());
		e.setType(EmployeeType.FULL_TIME);

		Employee e1 = new Employee();
		e1.setId(2);
		e1.setName("Gul");

		Employee e2 = new Employee();
		e2.setId(3);
		e2.setName("Gul");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-starter");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(e);
		entityManager.persist(e1);
		entityManager.persist(e2);
		transaction.commit();
	}
}