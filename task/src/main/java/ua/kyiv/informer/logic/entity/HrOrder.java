package ua.kyiv.informer.logic.entity;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hr_order")
public class HrOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hr_order_id")
	private UUID hrOrderId;
	
	@Column(name = "hr_order_name", nullable = false)
	private String hrOrderName;
	
	@Column(name = "hr_order_date")
	private Date hrOrderDate;
	
	@Column(name = "hr_order_number")
	private String hrOrderNumber;
	
	@Column(name = "hr_order_number_jurnal")
	private String hrOrderNumberJurnal;
	
	@Column(name = "hr_order_job_buh")
	private boolean hrOrderJobBuh;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Employee> employee;
	
	@Column(name = "hr_order_notes")
	private String hrOrderNotes;

	public HrOrder() {
		super();
	}

	public UUID getHrOrderId() {
		return hrOrderId;
	}

	public void setHrOrderId(UUID hrOrderId) {
		this.hrOrderId = hrOrderId;
	}

	public String getHrOrderName() {
		return hrOrderName;
	}

	public void setHrOrderName(String hrOrderName) {
		this.hrOrderName = hrOrderName;
	}

	public Date getHrOrderDate() {
		return hrOrderDate;
	}

	public void setHrOrderDate(Date hrOrderDate) {
		this.hrOrderDate = hrOrderDate;
	}

	public String getHrOrderNumber() {
		return hrOrderNumber;
	}

	public void setHrOrderNumber(String hrOrderNumber) {
		this.hrOrderNumber = hrOrderNumber;
	}

	public String getHrOrderNumberJurnal() {
		return hrOrderNumberJurnal;
	}

	public void setHrOrderNumberJurnal(String hrOrderNumberJurnal) {
		this.hrOrderNumberJurnal = hrOrderNumberJurnal;
	}

	public boolean isHrOrderJobBuh() {
		return hrOrderJobBuh;
	}

	public void setHrOrderJobBuh(boolean hrOrderJobBuh) {
		this.hrOrderJobBuh = hrOrderJobBuh;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	public String getHrOrderNotes() {
		return hrOrderNotes;
	}

	public void setHrOrderNotes(String hrOrderNotes) {
		this.hrOrderNotes = hrOrderNotes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employee, hrOrderDate, hrOrderId, hrOrderJobBuh, hrOrderName, hrOrderNotes, hrOrderNumber,
				hrOrderNumberJurnal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HrOrder other = (HrOrder) obj;
		return Objects.equals(employee, other.employee) && Objects.equals(hrOrderDate, other.hrOrderDate)
				&& Objects.equals(hrOrderId, other.hrOrderId) && hrOrderJobBuh == other.hrOrderJobBuh
				&& Objects.equals(hrOrderName, other.hrOrderName) && Objects.equals(hrOrderNotes, other.hrOrderNotes)
				&& Objects.equals(hrOrderNumber, other.hrOrderNumber)
				&& Objects.equals(hrOrderNumberJurnal, other.hrOrderNumberJurnal);
	}

	@Override
	public String toString() {
		return "HrOrder [hrOrderId=" + hrOrderId + ", hrOrderName=" + hrOrderName + ", hrOrderDate=" + hrOrderDate
				+ ", hrOrderNumber=" + hrOrderNumber + ", hrOrderNumberJurnal=" + hrOrderNumberJurnal
				+ ", hrOrderJobBuh=" + hrOrderJobBuh + ", employee=" + employee + ", hrOrderNotes=" + hrOrderNotes
				+ "]";
	}
	
	
}
