package ua.lviv.iot.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`department_type`", schema = "`shutka`")
public class DepartmentTypeEntity {
    private String size;
    private Integer maxWeight;

    @Id
    @Column(name = "size", nullable = false, length = 45)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "max_weight", nullable = false)
    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentTypeEntity that = (DepartmentTypeEntity) o;

        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (maxWeight != null ? !maxWeight.equals(that.maxWeight) : that.maxWeight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = size != null ? size.hashCode() : 0;
        result = 31 * result + (maxWeight != null ? maxWeight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DepartmentTypeEntity{" +
                "size='" + size + '\'' +
                ", maxWeight=" + maxWeight +
                '}';
    }
}
