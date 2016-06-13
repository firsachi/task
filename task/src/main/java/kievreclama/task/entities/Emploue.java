/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entities;

/**
 *
 * @author firsov
 */
public class Emploue implements Cloneable{
    
    private int id;
    private String login;

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }
    
    public String getLogin() {
        return login;
    }
    
}
