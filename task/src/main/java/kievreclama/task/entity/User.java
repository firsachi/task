/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author firsov
 */
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "login")
   // @UniqueConstraint(columnNames = "login")
    @OneToOne
    private String login;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
    
    
    
}
