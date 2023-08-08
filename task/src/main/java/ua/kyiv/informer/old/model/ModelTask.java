package ua.kyiv.informer.old.model;

/**
 *
 * @author firsov
 */
public class ModelTask {
    
    private int id;
    private String employee;
    private String task;
    private String number;
    private String date;
    private String urgensy;
    {
        urgensy = "5";
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUrgensy(String urgensy) {
        this.urgensy = urgensy;
    }

    public int getId() {
        return id;
    }

    public String getEmployee() {
        return employee;
    }

    public String getTask() {
        return task;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getUrgensy() {
        return urgensy;
    }

    
}
