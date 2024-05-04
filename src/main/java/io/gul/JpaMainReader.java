package io.gul;

import org.hibernate.Hibernate;

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
//			System.out.println("Employee AccessCard*****: ");
//			System.out.println(employee.getCard());
//			System.out.println("*******Accessing Employee PayStubs*********");
//			System.out.println(employee.getPayStubs());
			System.out.println("*******Accessing Employee Email Group*********");
			System.out.println(employee.getEmailGroup());

//			System.out.println("*******Accessing AccessCard*********");
//			AccessCard card = entityManager.find(AccessCard.class, 1);
//
//			System.out.println("AccessCard'sEmployee*****: ");
//			System.out.println(card.getOwner());

//			System.out.println("*******Accessing PayStub*********");
//			PayStub card = entityManager.find(PayStub.class, 1);
//			System.out.println("*******Accessing PayStub Employee*********");
//			System.out.println(card.getEmp());


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

/*
*******Accessing Employee*********
Hibernate:
select
employee0_.id as id1_1_0_,
employee0_.card_id as card_id5_1_0_,
employee0_.dob as dob2_1_0_,
employee0_.name as name3_1_0_,
employee0_.type as type4_1_0_,
accesscard1_.id as id1_0_1_,
accesscard1_.status as status2_0_1_
		from
employee employee0_
left outer join
access_card accesscard1_
on employee0_.card_id=accesscard1_.id
		where
employee0_.id=?
		*******Accessing Employee PayStubs*********
Hibernate:
select
paystub0_.pay_stub_for as pay_stub4_2_0_,
paystub0_.id as id1_2_0_,
paystub0_.id as id1_2_1_,
paystub0_.pay_stub_for as pay_stub4_2_1_,
paystub0_.month as month2_2_1_,
paystub0_.salary as salary3_2_1_
		from
pay_stub paystub0_
where
paystub0_.pay_stub_for=?
		[io.gul.PayStub@1d782abe, io.gul.PayStub@22fba58c]
 */
