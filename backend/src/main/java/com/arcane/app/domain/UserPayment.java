package com.arcane.app.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A UserPayment.
 */
@Entity
@Table(name = "user_payment")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "provider")
    private String provider;

    @Column(name = "balance")
    private Float balance;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public UserPayment id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public UserPayment paymentType(String paymentType) {
        this.setPaymentType(paymentType);
        return this;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getProvider() {
        return this.provider;
    }

    public UserPayment provider(String provider) {
        this.setProvider(provider);
        return this;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Float getBalance() {
        return this.balance;
    }

    public UserPayment balance(Float balance) {
        this.setBalance(balance);
        return this;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserPayment user(User user) {
        this.setUser(user);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserPayment)) {
            return false;
        }
        return id != null && id.equals(((UserPayment) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserPayment{" +
            "id=" + getId() +
            ", paymentType='" + getPaymentType() + "'" +
            ", provider='" + getProvider() + "'" +
            ", balance=" + getBalance() +
            "}";
    }
}
