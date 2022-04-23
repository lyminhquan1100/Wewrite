package com.arcane.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A OrderDetails.
 */
@Entity
@Table(name = "order_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "price")
    private Float price;

    @Column(name = "discount_value")
    private Integer discountValue;

    @Column(name = "discount_code")
    private String discountCode;

    @Column(name = "total")
    private Float total;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToOne
    @JsonIgnoreProperties(value = { "details", "user" }, allowSetters = true)
    private Order order;

    @ManyToOne
    @JsonIgnoreProperties(value = { "images", "orderDetails", "category", "tags" }, allowSetters = true)
    private Product product;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public OrderDetails id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public OrderDetails amount(Integer amount) {
        this.setAmount(amount);
        return this;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return this.price;
    }

    public OrderDetails price(Float price) {
        this.setPrice(price);
        return this;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getDiscountValue() {
        return this.discountValue;
    }

    public OrderDetails discountValue(Integer discountValue) {
        this.setDiscountValue(discountValue);
        return this;
    }

    public void setDiscountValue(Integer discountValue) {
        this.discountValue = discountValue;
    }

    public String getDiscountCode() {
        return this.discountCode;
    }

    public OrderDetails discountCode(String discountCode) {
        this.setDiscountCode(discountCode);
        return this;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Float getTotal() {
        return this.total;
    }

    public OrderDetails total(Float total) {
        this.setTotal(total);
        return this;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public OrderDetails createdAt(LocalDate createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderDetails order(Order order) {
        this.setOrder(order);
        return this;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderDetails product(Product product) {
        this.setProduct(product);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderDetails)) {
            return false;
        }
        return id != null && id.equals(((OrderDetails) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OrderDetails{" +
            "id=" + getId() +
            ", amount=" + getAmount() +
            ", price=" + getPrice() +
            ", discountValue=" + getDiscountValue() +
            ", discountCode='" + getDiscountCode() + "'" +
            ", total=" + getTotal() +
            ", createdAt='" + getCreatedAt() + "'" +
            "}";
    }
}
