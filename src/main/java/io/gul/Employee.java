package io.gul;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {
	@Basic
	private String name;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Enumerated(EnumType.STRING)
	@Column(updatable = false, length = 10)
	private EmployeeType type;

	@OneToOne
	private AccessCard card;

	@OneToMany(mappedBy = "emp") // By default, its Lazy
	private List<PayStub> payStub;

	@ManyToMany
	@JoinTable(name = "employee_email_group", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "emp_group_id"))
	private List<EmailGroup> emailGroup;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public EmployeeType getType() {
		return type;
	}

	public void setType(EmployeeType type) {
		this.type = type;
	}

	public AccessCard getCard() {
		return card;
	}

	public void setCard(AccessCard card) {
		this.card = card;
	}

	public List<PayStub> getPayStubs() {
		return payStub;
	}

	public void setPayStubs(List<PayStub> payStubs) {
		this.payStub = payStubs;
	}

	public List<PayStub> getPayStub() {
		return payStub;
	}

	public void setPayStub(List<PayStub> payStub) {
		this.payStub = payStub;
	}

	public List<EmailGroup> getEmailGroup() {
		return emailGroup;
	}

	public void setEmailGroup(List<EmailGroup> emailGroup) {
		this.emailGroup = emailGroup;
	}

}
