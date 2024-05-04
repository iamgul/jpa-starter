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

			System.out.println("*******Accessing AccessCard*********");
			AccessCard card = entityManager.find(AccessCard.class, 1);

			System.out.println("AccessCard'sEmployee*****: ");
			System.out.println(card.getOwner());
	/*
			*******Accessing AccessCard*********
			Hibernate:
			select
			accesscard0_.id as id1_0_0_,
					accesscard0_.status as status2_0_0_
			from
			access_card accesscard0_
			where
			accesscard0_.id=?
			Hibernate:
			select
			employee0_.id as id1_1_1_,
					employee0_.card_id as card_id5_1_1_,
			employee0_.dob as dob2_1_1_,
					employee0_.name as name3_1_1_,
			employee0_.type as type4_1_1_,
					accesscard1_.id as id1_0_0_,
			accesscard1_.status as status2_0_0_
					from
			employee employee0_
			left outer join
			access_card accesscard1_
			on employee0_.card_id=accesscard1_.id
			where
			employee0_.card_id=?
			AccessCard'sEmployee*****:
			Employee{id=1, name='Gul', dob=2024-05-04, type=FULL_TIME, card=AccessCard{id=1, status=ACTIVE, owner=}}*/

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
