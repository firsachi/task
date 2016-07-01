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
public class SettingsFilter {
    
    private int custumer;
    private int priority;
    private int statys = 2;
    
    public void setCustumer(String custumer) {
        this.custumer = new Integer(custumer);
    }

    public void setPriority(String priority) {
        this.priority = new Integer(priority);
    }

    public void setStatys(String statys) {
        this.statys = new Integer(statys);
    }

    public int getCustumer() {
        return custumer;
    }

    public int getPriority() {
        return priority;
    }

    public int isStatys() {
        return statys;
    }
    
    public String getQuery(){
        StringBuilder sql = new StringBuilder();
        sql.append(SqlQuery.ALL_TASK);
        sql.append(initCustumer());
        sql.append(initPriority());
        sql.append(initStatys());
        sql.append(" ORDER BY urgency");
        System.out.println(sql.toString());
        return sql.toString();
    }

    private String initCustumer() {
        if ( 0 != custumer ){
            return "AND tasks.emploue=" + custumer;
        }
        return "";
    }

    private String initPriority() {
        if (0 != priority){
            return "AND tasks.urgency=" + priority;
        }
        return "";
    }
        
    private String initStatys() {
        if (2 == statys) {
            return " AND state=false";
        }else if(1 == statys){
            return " AND state=true";
        }
        return "";
    }

}
