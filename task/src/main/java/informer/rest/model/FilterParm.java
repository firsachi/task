package informer.rest.model;

import java.util.Objects;

public class FilterParm {
	
	private int companyId;
	
	private int deparmentId;

    public FilterParm(int companyId, int departmentId) {
		this.companyId = companyId;
		this.deparmentId = departmentId;
    }

    public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getDeparmentId() {
		return deparmentId;
	}

	public void setDeparmentId(int deparmentId) {
		this.deparmentId = deparmentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyId, deparmentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilterParm other = (FilterParm) obj;
		return companyId == other.companyId && deparmentId == other.deparmentId;
	}

	@Override
	public String toString() {
		return "FilterParm [companyId=" + companyId + ", deparmentId=" + deparmentId + "]";
	}
	
}
