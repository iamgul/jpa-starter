package io.gul;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Date;

public class JpaMainWriter {
	public static void main(String[] args) {

		Employee e = new Employee();
		e.setName("Gul");
		e.setDob(new Date());
		e.setType(EmployeeType.FULL_TIME);


		Employee e1 = new Employee();
		e1.setName("Mohammed");
		e1.setDob(new Date());
		e1.setType(EmployeeType.PART_TIME);

		AccessCard card1 = new AccessCard();
		card1.setStatus(Status.ACTIVE);
		card1.setOwner(e);

		e.setCard(card1);

		AccessCard card2 = new AccessCard();
		card2.setStatus(Status.INACTIVE);
		card2.setOwner(e1);

		e1.setCard(card2);


		EntityManagerFactory entityManagerFactory = PersistenceManager.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {

			transaction.begin();

			entityManager.persist(e);
			entityManager.persist(e1);

			entityManager.persist(card1);
			entityManager.persist(card2);

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