/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author firsov
 */
@Entity
@Table(name = "tasks")
public class Task implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
     
    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;
    
    @Column(name = "task")
    private String task;
    
    @Column(name = "number")
    private String number;
    
    @Column(name = "date_create")
    private Date date;
    {
        date = new Date();
    }
    
    @Column(name = "urgency")
    private Integer urgensy;
    
    @Column(name = "state")
    private Boolean state;
    
    @Column(name = "delete")
    private Boolean delete;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUrgensy(Integer urgensy) {
        this.urgensy = urgensy;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getTask() {
        return task;
    }

    public String getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }

    public Integer getUrgensy() {
        return urgensy;
    }

    public Boolean getState() {
        return state;
    }

    public Boolean getDelete() {
        return delete;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((dateFormat == null) ? 0 : dateFormat.hashCode());
		result = prime * result + ((delete == null) ? 0 : delete.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + id;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((task == null) ? 0 : task.hashCode());
		result = prime * result + ((urgensy == null) ? 0 : urgensy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dateFormat == null) {
			if (other.dateFormat != null)
				return false;
		} else if (!dateFormat.equals(other.dateFormat))
			return false;
		if (delete == null) {
			if (other.delete != null)
				return false;
		} else if (!delete.equals(other.delete))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id != other.id)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		if (urgensy == null) {
			if (other.urgensy != null)
				return false;
		} else if (!urgensy.equals(other.urgensy))
			return false;
		return true;
	}
    
    
}
