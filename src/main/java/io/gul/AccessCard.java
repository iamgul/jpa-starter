package io.gul;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "access_card")
public class AccessCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToOne(mappedBy = "card",fetch = FetchType.LAZY) // It seems FetchTpe.LAZY doesn't behave properly with @mappedBy, since even if it's Lazy it creates one more query which does Select Employee OuterJoin AccessCard;
	private Employee owner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "AccessCard{" + "id=" + id + ", status=" + status + ", owner="  + '}';
	}
}
