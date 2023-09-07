package ua.kyiv.informer.logic.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author firsov
 */
@Entity
@Table(name = "employee")
@NamedQueries({
	@NamedQuery (
			name = "allEmployee", 
			query = "SELECT E FROM Employee E ORDER BY E.remove"),
	@NamedQuery (
			name = "employeeDepartment", 
			query = "SELECT E FROM Employee E WHERE E.enterprise.id = :companuId AND E.department.id = :departmentId ORDER BY E.position.heft"),
	@NamedQuery (
			name = "employees", 
			query = "SELECT E FROM Employee E ORDER BY E.id"),
	@NamedQuery (
			name = "deleteEmployee", 
			query = "UPDATE Employee E SET E.remove = true WHERE E.id=:id"),
	@NamedQuery (
			name = "selectIdDepartment", 
			query = "SELECT E FROM Employee E WHERE E.remove = false AND E.department.id = :departmentId ORDER BY E.position.heft"),
	@NamedQuery (
			name = "selectEmployee",
			query = "SELECT E FROM Employee E WHERE E.remove = :disable ORDER BY E.surname ")
})
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "patronymic")
    private String patronymic;
    
    @JoinColumn(name = "phone", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Phone phone;
    
    @JoinColumn(name = "post", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Position position;
    
    @JoinColumn(name = "department", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;
    
    @JoinColumn(name = "enterprise", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company enterprise;
    
    @Column(name = "email")
    private String email;
    
    @JoinColumn(name = "room", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;
    
    @Column(name = "login", unique = true, nullable = true)
    private String login;
    
    @Column(name = "pass", nullable = true)
    private String password;
    
    @ManyToMany(mappedBy = "employee")
    private List<HrOrder> hrOrderList;

    @Column (name = "remove", columnDefinition = "boolean default false", nullable = false)
    private Boolean remove = false;

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Company getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Company enterprise) {
		this.enterprise = enterprise;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public List<HrOrder> getHrOrderList() {
		return hrOrderList;
	}

	public void setHrOrderList(List<HrOrder> hrOrderList) {
		this.hrOrderList = hrOrderList;
	}

	public Boolean getRemove() {
		return remove;
	}

	public void setRemove(Boolean remove) {
		this.remove = remove;
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, email, enterprise, hrOrderList, id, login, name, password, patronymic, phone,
				position, remove, room, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(department, other.department) && Objects.equals(email, other.email)
				&& Objects.equals(enterprise, other.enterprise) && Objects.equals(hrOrderList, other.hrOrderList)
				&& id == other.id && Objects.equals(login, other.login) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(patronymic, other.patronymic)
				&& Objects.equals(phone, other.phone) && Objects.equals(position, other.position)
				&& Objects.equals(remove, other.remove) && Objects.equals(room, other.room)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", surname=" + surname + ", name=" + name + ", patronymic=" + patronymic
				+ ", phone=" + phone + ", position=" + position + ", department=" + department + ", enterprise="
				+ enterprise + ", email=" + email + ", room=" + room + ", login=" + login + ", pass=" + password
				+ ", hrOrderList=" + hrOrderList + ", remove=" + remove + "]";
	}

}
