package com.arcane.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Product.
 */
@Entity
@Table(name = "product")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "price")
    private Float price;

    @OneToMany(mappedBy = "products")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "user", "products" }, allowSetters = true)
    private Set<Image> images = new HashSet<>();

    @OneToMany(mappedBy = "product")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "order", "product" }, allowSetters = true)
    private Set<OrderDetails> orderDetails = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "products" }, allowSetters = true)
    private ProductCategory category;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//    @JsonIgnoreProperties(value = { "products" }, allowSetters = true)
    private Set<Tag> tags = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Product id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Product name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return this.content;
    }

    public Product content(String content) {
        this.setContent(content);
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Float getPrice() {
        return this.price;
    }

    public Product price(Float price) {
        this.setPrice(price);
        return this;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Set<Image> getImages() {
        return this.images;
    }

    public void setImages(Set<Image> images) {
        if (this.images != null) {
            this.images.forEach(i -> i.setProducts(null));
        }
        if (images != null) {
            images.forEach(i -> i.setProducts(this));
        }
        this.images = images;
    }

    public Product images(Set<Image> images) {
        this.setImages(images);
        return this;
    }

    public Product addImage(Image image) {
        this.images.add(image);
        image.setProducts(this);
        return this;
    }

    public Product removeImage(Image image) {
        this.images.remove(image);
        image.setProducts(null);
        return this;
    }

    public Set<OrderDetails> getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        if (this.orderDetails != null) {
            this.orderDetails.forEach(i -> i.setProduct(null));
        }
        if (orderDetails != null) {
            orderDetails.forEach(i -> i.setProduct(this));
        }
        this.orderDetails = orderDetails;
    }

    public Product orderDetails(Set<OrderDetails> orderDetails) {
        this.setOrderDetails(orderDetails);
        return this;
    }

    public Product addOrderDetail(OrderDetails orderDetails) {
        this.orderDetails.add(orderDetails);
        orderDetails.setProduct(this);
        return this;
    }

    public Product removeOrderDetail(OrderDetails orderDetails) {
        this.orderDetails.remove(orderDetails);
        orderDetails.setProduct(null);
        return this;
    }

    public ProductCategory getCategory() {
        return this.category;
    }

    public void setCategory(ProductCategory productCategory) {
        this.category = productCategory;
    }

    public Product category(ProductCategory productCategory) {
        this.setCategory(productCategory);
        return this;
    }

    public Set<Tag> getTags() {
        return this.tags;
    }

    public void setTags(Set<Tag> tags) {
        if (this.tags != null) {
            this.tags.forEach(i -> i.removeProducts(this));
        }
        if (tags != null) {
            tags.forEach(i -> i.addProducts(this));
        }
        this.tags = tags;
    }

    public Product tags(Set<Tag> tags) {
        this.setTags(tags);
        return this;
    }

    public Product addTags(Tag tag) {
        this.tags.add(tag);
        tag.getProducts().add(this);
        return this;
    }

    public Product removeTags(Tag tag) {
        this.tags.remove(tag);
        tag.getProducts().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        return id != null && id.equals(((Product) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Product{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", content='" + getContent() + "'" +
            ", price=" + getPrice() +
            "}";
    }
}
