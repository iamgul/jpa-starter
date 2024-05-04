package io.gul;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Month;

@Entity
@Table(name = "pay_stub")
public class PayStub extends BaseEntity {

	private float salary;

	@Enumerated(EnumType.STRING)
	private Month month;

	@ManyToOne
	@JoinColumn(name = "pay_stub_for")
	private Employee emp;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
}
