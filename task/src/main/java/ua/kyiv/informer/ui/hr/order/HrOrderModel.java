package ua.kyiv.informer.ui.hr.order;

import java.util.Objects;
import java.util.UUID;

public class HrOrderModel {
	
	private UUID hrOrderId;
	
	private String hrOrderName;
	
	private String hrOrderDate;
	
	private String hrOrderNumber;
	
	private String hrOrderNumberJurnal;
	
	private boolean hrOrderJobBuh;
	
	private String hrOrderNotes;

	public HrOrderModel() {
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

	public String getHrOrderDate() {
		return hrOrderDate;
	}

	public void setHrOrderDate(String hrOrderDate) {
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

	public String getHrOrderNotes() {
		return hrOrderNotes;
	}

	public void setHrOrderNotes(String hrOrderNotes) {
		this.hrOrderNotes = hrOrderNotes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hrOrderDate, hrOrderId, hrOrderJobBuh, hrOrderName, hrOrderNotes, hrOrderNumber,
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
		HrOrderModel other = (HrOrderModel) obj;
		return Objects.equals(hrOrderDate, other.hrOrderDate) && Objects.equals(hrOrderId, other.hrOrderId)
				&& hrOrderJobBuh == other.hrOrderJobBuh && Objects.equals(hrOrderName, other.hrOrderName)
				&& Objects.equals(hrOrderNotes, other.hrOrderNotes)
				&& Objects.equals(hrOrderNumber, other.hrOrderNumber)
				&& Objects.equals(hrOrderNumberJurnal, other.hrOrderNumberJurnal);
	}

	@Override
	public String toString() {
		return "HrOrderModel [hrOrderId=" + hrOrderId + ", hrOrderName=" + hrOrderName + ", hrOrderDate=" + hrOrderDate
				+ ", hrOrderNumber=" + hrOrderNumber + ", hrOrderNumberJurnal=" + hrOrderNumberJurnal
				+ ", hrOrderJobBuh=" + hrOrderJobBuh + ", hrOrderNotes=" + hrOrderNotes + "]";
	}
	
}
