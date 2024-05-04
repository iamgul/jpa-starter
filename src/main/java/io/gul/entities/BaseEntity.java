package io.gul.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "time_created")
	private Date timeCreated;

	@Temporal(TemporalType.DATE)
	@Column(name = "time_modified")
	private Date timeModified;

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Date getTimeModified() {
		return timeModified;
	}

	public void setTimeModified(Date timeModified) {
		this.timeModified = timeModified;
	}
}

