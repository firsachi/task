package informer.old;

import jakarta.validation.constraints.Size;

public class EmployeeModel {

    private int id;
    
    @Size(min = 2, max = 150)
    private String surname;
    
    @Size(min = 2, max = 150)
    private String name;
    
    @Size(min = 2, max = 150)
    private String patronymic;
    
    private int idPhone;
    
    private String phone;
    
    private int idPost;
    
    private String post;
    
    private int idDepartment;
    
    private String department;
    
    private int idEnterprise;
    
    private String enterprise;
    
    private String email;
    
    private int idRoom;
    
    private int room;
    
    @Size(min = 2, max = 150)
    private String login;
    
    @Size(min = 8)
    private String password;
    
    private boolean disable;
	
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

	public int getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(int idPhone) {
		this.idPhone = idPhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getIdEnterprise() {
		return idEnterprise;
	}

	public void setIdEnterprise(int idEnterprise) {
		this.idEnterprise = idEnterprise;
	}

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", surname=" + surname + ", name=" + name + ", patronymic=" + patronymic
				+ ", idPhone=" + idPhone + ", phone=" + phone + ", idPost=" + idPost + ", post=" + post
				+ ", idDepartment=" + idDepartment + ", department=" + department + ", idEnterprise=" + idEnterprise
				+ ", enterprise=" + enterprise + ", email=" + email + ", idRoom=" + idRoom + ", room=" + room
				+ ", login=" + login + ", password=" + password + ", remove=" + disable + "]";
	}
	
}
