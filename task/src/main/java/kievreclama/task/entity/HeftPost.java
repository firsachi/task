/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author firsachi
 */
@Entity
@Table(name = "heft")
public class HeftPost implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(name = "heft", unique = false, nullable = false)
    private String heft;

    public void setId(int id) {
        this.id = id;
    }

    public void setHeft(String heft) {
        this.heft = heft;
    }

    public int getId() {
        return id;
    }

    public String getHeft() {
        return heft;
    }
    
    
}
