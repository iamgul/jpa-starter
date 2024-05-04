package io.gul;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	private static  EntityManagerFactory entityManagerFactory;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpa-starter");
	}

	public static  EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
