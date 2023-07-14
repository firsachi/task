package informer.old.models;

/**
 *
 * @author firsov
 */
public class ModelPost {
    
    private int id;
    private String name;
    private String heft;
    private final String[] HEFT_POST = {"1.0","1.1","2.0","2.1","3.0","3.1","4.0","4.1","5.0","5.1","6.0","6.1","7.0","7.1","8.0","8.1","9.0","9.1"};
    
    {
        heft = HEFT_POST[HEFT_POST.length - 1];
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeft(String heft) {
        this.heft = heft;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeft() {
        return heft;
    }

    public String[] getHEFT_POST() {
        return HEFT_POST.clone();
    }
    
    
}
