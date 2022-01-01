package ua.lviv.iot.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "`order`", schema = "`shutka`")
public class OrderEntity {
    private Integer id;
    private Integer fromDepartmentId;
    private Integer toDepartmentId;
    private Integer fromOperatorId;
    private Integer toOperatorId;
    private Integer fromCourierId;
    private Integer toCourierId;
    private Integer fromClientId;
    private Integer toClientId;
    private BigDecimal deliveryPrice;
    private BigDecimal productPrice;
    private Integer weight;
    private Date sendingDate;
    private Date approximateArrivalDate;
    private Date fixedArrivalDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "from_department_id", nullable = false)
    public Integer getFromDepartmentId() {
        return fromDepartmentId;
    }

    public void setFromDepartmentId(Integer fromDepartmentId) {
        this.fromDepartmentId = fromDepartmentId;
    }

    @Basic
    @Column(name = "to_department_id", nullable = false)
    public Integer getToDepartmentId() {
        return toDepartmentId;
    }

    public void setToDepartmentId(Integer toDepartmentId) {
        this.toDepartmentId = toDepartmentId;
    }

    @Basic
    @Column(name = "from_operator_id", nullable = false)
    public Integer getFromOperatorId() {
        return fromOperatorId;
    }

    public void setFromOperatorId(Integer fromOperatorId) {
        this.fromOperatorId = fromOperatorId;
    }

    @Basic
    @Column(name = "to_operator_id", nullable = false)
    public Integer getToOperatorId() {
        return toOperatorId;
    }

    public void setToOperatorId(Integer toOperatorId) {
        this.toOperatorId = toOperatorId;
    }

    @Basic
    @Column(name = "from_courier_id", nullable = true)
    public Integer getFromCourierId() {
        return fromCourierId;
    }

    public void setFromCourierId(Integer fromCourierId) {
        this.fromCourierId = fromCourierId;
    }

    @Basic
    @Column(name = "to_courier_id", nullable = true)
    public Integer getToCourierId() {
        return toCourierId;
    }

    public void setToCourierId(Integer toCourierId) {
        this.toCourierId = toCourierId;
    }

    @Basic
    @Column(name = "from_client_id", nullable = false)
    public Integer getFromClientId() {
        return fromClientId;
    }

    public void setFromClientId(Integer fromClientId) {
        this.fromClientId = fromClientId;
    }

    @Basic
    @Column(name = "to_client_id", nullable = false)
    public Integer getToClientId() {
        return toClientId;
    }

    public void setToClientId(Integer toClientId) {
        this.toClientId = toClientId;
    }

    @Basic
    @Column(name = "delivery_price", nullable = false)
    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    @Basic
    @Column(name = "product_price", nullable = true)
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "weight", nullable = false)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "sending_date", nullable = false)
    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    @Basic
    @Column(name = "approximate_arrival_date", nullable = false)
    public Date getApproximateArrivalDate() {
        return approximateArrivalDate;
    }

    public void setApproximateArrivalDate(Date approximateArrivalDate) {
        this.approximateArrivalDate = approximateArrivalDate;
    }

    @Basic
    @Column(name = "fixed_arrival_date", nullable = true)
    public Date getFixedArrivalDate() {
        return fixedArrivalDate;
    }

    public void setFixedArrivalDate(Date fixedArrivalDate) {
        this.fixedArrivalDate = fixedArrivalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fromDepartmentId != null ? !fromDepartmentId.equals(that.fromDepartmentId) : that.fromDepartmentId != null)
            return false;
        if (toDepartmentId != null ? !toDepartmentId.equals(that.toDepartmentId) : that.toDepartmentId != null)
            return false;
        if (fromOperatorId != null ? !fromOperatorId.equals(that.fromOperatorId) : that.fromOperatorId != null)
            return false;
        if (toOperatorId != null ? !toOperatorId.equals(that.toOperatorId) : that.toOperatorId != null) return false;
        if (fromCourierId != null ? !fromCourierId.equals(that.fromCourierId) : that.fromCourierId != null)
            return false;
        if (toCourierId != null ? !toCourierId.equals(that.toCourierId) : that.toCourierId != null) return false;
        if (fromClientId != null ? !fromClientId.equals(that.fromClientId) : that.fromClientId != null) return false;
        if (toClientId != null ? !toClientId.equals(that.toClientId) : that.toClientId != null) return false;
        if (deliveryPrice != null ? !deliveryPrice.equals(that.deliveryPrice) : that.deliveryPrice != null)
            return false;
        if (productPrice != null ? !productPrice.equals(that.productPrice) : that.productPrice != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (sendingDate != null ? !sendingDate.equals(that.sendingDate) : that.sendingDate != null) return false;
        if (approximateArrivalDate != null ? !approximateArrivalDate.equals(that.approximateArrivalDate) : that.approximateArrivalDate != null)
            return false;
        if (fixedArrivalDate != null ? !fixedArrivalDate.equals(that.fixedArrivalDate) : that.fixedArrivalDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fromDepartmentId != null ? fromDepartmentId.hashCode() : 0);
        result = 31 * result + (toDepartmentId != null ? toDepartmentId.hashCode() : 0);
        result = 31 * result + (fromOperatorId != null ? fromOperatorId.hashCode() : 0);
        result = 31 * result + (toOperatorId != null ? toOperatorId.hashCode() : 0);
        result = 31 * result + (fromCourierId != null ? fromCourierId.hashCode() : 0);
        result = 31 * result + (toCourierId != null ? toCourierId.hashCode() : 0);
        result = 31 * result + (fromClientId != null ? fromClientId.hashCode() : 0);
        result = 31 * result + (toClientId != null ? toClientId.hashCode() : 0);
        result = 31 * result + (deliveryPrice != null ? deliveryPrice.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (sendingDate != null ? sendingDate.hashCode() : 0);
        result = 31 * result + (approximateArrivalDate != null ? approximateArrivalDate.hashCode() : 0);
        result = 31 * result + (fixedArrivalDate != null ? fixedArrivalDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", fromDepartmentId=" + fromDepartmentId +
                ", toDepartmentId=" + toDepartmentId +
                ", fromOperatorId=" + fromOperatorId +
                ", toOperatorId=" + toOperatorId +
                ", fromCourierId=" + fromCourierId +
                ", toCourierId=" + toCourierId +
                ", fromClientId=" + fromClientId +
                ", toClientId=" + toClientId +
                ", deliveryPrice=" + deliveryPrice +
                ", productPrice=" + productPrice +
                ", weight=" + weight +
                ", sendingDate=" + sendingDate +
                ", approximateArrivalDate=" + approximateArrivalDate +
                ", fixedArrivalDate=" + fixedArrivalDate +
                '}';
    }
}
