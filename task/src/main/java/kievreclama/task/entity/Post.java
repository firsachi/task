/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author firsov
 */
@Entity
public class Post implements Serializable {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    {
        id = 0;
    }
    
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    
    @Column(name = "heft", unique = true, nullable = false)
    private String heft;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeft(String heft) {
        this.heft = heft;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeft() {
        return heft;
    }
    
}
