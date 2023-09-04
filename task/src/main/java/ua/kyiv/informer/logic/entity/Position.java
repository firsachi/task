package ua.kyiv.informer.logic.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author firsov
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "allPositions", query = "SELECT P FROM Position P ORDER BY P.disable"),
        @NamedQuery(name = "position.datalist", query = "SELECT P FROM Position P WHERE P.disable = false ORDER BY P.namePosition"),
        @NamedQuery(name = "deletePost", query = "UPDATE Position P SET P.disable = true WHERE P.id = :id"),
		@NamedQuery(name = "position.isUnique", query = "SELECT p FROM Position p WHERE p.id <> :id AND p.namePosition = :namePosition"),
        @NamedQuery(name = "position.findNamePosition", query = "SELECT p FROM Position p WHERE p.namePosition = :namePosition")
})
public class Position implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String namePosition;

    @Column(name = "heft", nullable = false)
    private String heft;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employees;

    @Column
    private boolean disable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

    public String getHeft() {
        return heft;
    }

    public void setHeft(String heft) {
        this.heft = heft;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return disable == position.disable && Objects.equals(id, position.id) && Objects.equals(namePosition, position.namePosition) && Objects.equals(heft, position.heft) && Objects.equals(employees, position.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namePosition, heft, employees, disable);
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", namePosition='" + namePosition + '\'' +
                ", heft='" + heft + '\'' +
                ", employees=" + employees +
                ", disable=" + disable +
                '}';
    }
}
