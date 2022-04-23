package com.arcane.app.domain;

import com.arcane.app.domain.enumeration.State;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Order.
 */
@Entity
@Table(name = "jhi_order")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    @Column(name = "total_price")
    private Float totalPrice;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @OneToMany(mappedBy = "order")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "order", "product" }, allowSetters = true)
    private Set<OrderDetails> details = new HashSet<>();

    @ManyToOne
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Order id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public State getState() {
        return this.state;
    }

    public Order state(State state) {
        this.setState(state);
        return this;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Float getTotalPrice() {
        return this.totalPrice;
    }

    public Order totalPrice(Float totalPrice) {
        this.setTotalPrice(totalPrice);
        return this;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public Order createdAt(LocalDate createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<OrderDetails> getDetails() {
        return this.details;
    }

    public void setDetails(Set<OrderDetails> orderDetails) {
        if (this.details != null) {
            this.details.forEach(i -> i.setOrder(null));
        }
        if (orderDetails != null) {
            orderDetails.forEach(i -> i.setOrder(this));
        }
        this.details = orderDetails;
    }

    public Order details(Set<OrderDetails> orderDetails) {
        this.setDetails(orderDetails);
        return this;
    }

    public Order addDetails(OrderDetails orderDetails) {
        this.details.add(orderDetails);
        orderDetails.setOrder(this);
        return this;
    }

    public Order removeDetails(OrderDetails orderDetails) {
        this.details.remove(orderDetails);
        orderDetails.setOrder(null);
        return this;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order user(User user) {
        this.setUser(user);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        return id != null && id.equals(((Order) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Order{" +
            "id=" + getId() +
            ", state='" + getState() + "'" +
            ", totalPrice=" + getTotalPrice() +
            ", createdAt='" + getCreatedAt() + "'" +
            "}";
    }
}
