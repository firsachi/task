/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers.models;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kievreclama.task.dao.CompanyDao;
import kievreclama.task.dao.DepartmentDao;
import kievreclama.task.dao.PhoneDao;
import kievreclama.task.dao.PostDao;
import kievreclama.task.dao.RoomDao;
import kievreclama.task.dao.impl.CompanyDaoImpl;
import kievreclama.task.dao.impl.DepartmentDaoImpl;
import kievreclama.task.dao.impl.PhoneDaoImpl;
import kievreclama.task.dao.impl.PostDaoImpl;
import kievreclama.task.dao.impl.RoomDaoImpl;
import kievreclama.task.entity.Company;
import kievreclama.task.entity.Department;
import kievreclama.task.entity.Phone;
import kievreclama.task.entity.Post;
import kievreclama.task.entity.Room;

/**
 *
 * @author firsov
 */
public class ModelEmployee {

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private Integer phone;
    private List<Phone> listPhone;
    {
        PhoneDao phoneDao = new PhoneDaoImpl();
        try {
            listPhone = phoneDao.list();
        } catch (SQLException ex) {
            Logger.getLogger(ModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Integer post;
    private List<Post> listPost;
    {
        PostDao postDao = new PostDaoImpl();
        try {
            listPost = postDao.list();
        } catch (SQLException ex) {
            Logger.getLogger(ModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Integer department;
    private List<Department> listDeapartment;
    {
        DepartmentDao departmentDao = new DepartmentDaoImpl();
        try {
            listDeapartment = departmentDao.list();
        } catch (SQLException ex) {
            Logger.getLogger(ModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Integer enterprise;
    private List<Company> listCompany;
    {
        CompanyDao companyDao = new CompanyDaoImpl();
        try {
            listCompany = companyDao.getList();
        } catch (SQLException ex) {
            Logger.getLogger(ModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String email;
    private Integer numberRoom;
    private List<Room> listRoom;
    {
                RoomDao roomDao = new RoomDaoImpl();
        try {
            listRoom = roomDao.list();
        } catch (SQLException ex) {
            Logger.getLogger(ModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public void setEnterprise(Integer enterprise) {
        this.enterprise = enterprise;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumberRoom(Integer numberRoom) {
        this.numberRoom = numberRoom;
    }

    public void setListPhone(List<Phone> listPhone) {
        this.listPhone = listPhone;
    }

    public void setListPost(List<Post> llistPost) {
        this.listPost = llistPost;
    }

    public void setListDeapartment(List<Department> listDeapartment) {
        this.listDeapartment = listDeapartment;
    }

    public void setListCompany(List<Company> listCompany) {
        this.listCompany = listCompany;
    }

    public void setListRoom(List<Room> listRoom) {
        this.listRoom = listRoom;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Integer getPhone() {
        return phone;
    }

    public Integer getPost() {
        return post;
    }

    public Integer getDepartment() {
        return department;
    }

    public Integer getEnterprise() {
        return enterprise;
    }

    public String getEmail() {
        return email;
    }

    public Integer getNumberRoom() {
        return numberRoom;
    }

    public List<Phone> getListPhone() {
        return listPhone;
    }

    public List<Post> getListPost() {
        return listPost;
    }

    public List<Department> getListDeapartment() {
        return listDeapartment;
    }

    public List<Company> getListCompany() {
        return listCompany;
    }

    public List<Room> getListRoom() {
        return listRoom;
    }
    
}
