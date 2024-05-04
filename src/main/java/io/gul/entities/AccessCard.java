package io.gul.entities;

import io.gul.enums.Status;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "access_card")
public class AccessCard extends BaseEntity {

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToOne(mappedBy = "card",fetch = FetchType.LAZY) // It seems FetchTpe.LAZY doesn't behave properly with @mappedBy, since even if it's Lazy it creates one more query which does Select Employee OuterJoin AccessCard;
	private Employee owner;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}


}
