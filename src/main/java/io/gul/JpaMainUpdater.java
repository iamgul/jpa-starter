package io.gul;

import io.gul.entities.EmailGroup;
import io.gul.entities.Employee;
import io.gul.persistence.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaMainUpdater {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = PersistenceManager.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		Employee employee = entityManager.find(Employee.class, 2);
		EmailGroup emailGroup = entityManager.find(EmailGroup.class, 2);
		List<EmailGroup> emailGroup1 = employee.getEmailGroup();
		emailGroup1.add(emailGroup);
		employee.setEmailGroup(emailGroup1);

		List<Employee> employee1 = emailGroup.getEmployee();
		employee1.add(employee);
		emailGroup.setEmployee(employee1);

		try {
			transaction.begin();
			entityManager.persist(employee);
			entityManager.persist(emailGroup);
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
