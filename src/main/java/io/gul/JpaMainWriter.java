package io.gul;

import io.gul.entities.AccessCard;
import io.gul.entities.EmailGroup;
import io.gul.entities.Employee;
import io.gul.entities.PayStub;
import io.gul.enums.EmployeeType;
import io.gul.enums.Status;
import io.gul.persistence.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.Month;
import java.util.Arrays;
import java.util.Date;

public class JpaMainWriter {
	public static void main(String[] args) {

		Employee e0 = new Employee();
		e0.setName("Gul");
		e0.setDob(new Date());
		e0.setType(EmployeeType.FULL_TIME);


		Employee e1 = new Employee();
		e1.setName("Mohammed");
		e1.setDob(new Date());
		e1.setType(EmployeeType.PART_TIME);

		AccessCard card1 = new AccessCard();
		card1.setStatus(Status.ACTIVE);
		card1.setOwner(e0);

		e0.setCard(card1);

		AccessCard card2 = new AccessCard();
		card2.setStatus(Status.INACTIVE);
		card2.setOwner(e1);

		e1.setCard(card2);


		PayStub payStub1 = new PayStub();
		payStub1.setMonth(Month.MARCH);
		payStub1.setSalary(20_000);
		payStub1.setEmp(e0);

		PayStub payStub2 = new PayStub();
		payStub2.setMonth(Month.valueOf("APRIL"));
		payStub2.setSalary(30_000);
		payStub2.setEmp(e0);

		PayStub payStub3 = new PayStub();
		payStub3.setMonth(Month.MAY);
		payStub3.setSalary(30_000_00);
		payStub3.setEmp(e1);
		e1.setPayStubs(Arrays.asList(payStub3));

		e0.setPayStubs(Arrays.asList(payStub1,payStub2)); // Even if we don't set this value w can fetch the Emloyee payStubs, so it is highly recommended to set this


		EmailGroup eg1 = new EmailGroup();
		eg1.setDepartment("ENGINEERING");
		eg1.setTimeCreated(new Date());
		eg1.setTimeModified(new Date());
		eg1.setEmployee(Arrays.asList(e0,e1));

		EmailGroup eg2 = new EmailGroup();
		eg2.setDepartment("MANAGEMENT");
		eg2.setTimeCreated(new Date());
		eg2.setTimeModified(new Date());
		eg2.setEmployee(Arrays.asList(e0));

		e0.setEmailGroup(Arrays.asList(eg1,eg2));
		e1.setEmailGroup(Arrays.asList(eg1));


		EntityManagerFactory entityManagerFactory = PersistenceManager.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {

			transaction.begin();

			entityManager.persist(e0);
			entityManager.persist(e1);

			entityManager.persist(card1);
			entityManager.persist(card2);

			entityManager.persist(payStub1);
			entityManager.persist(payStub2);
			entityManager.persist(payStub3);


			entityManager.persist(eg1);
			entityManager.persist(eg2);

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