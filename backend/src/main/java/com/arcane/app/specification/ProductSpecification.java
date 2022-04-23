package com.arcane.app.specification;

import com.arcane.app.domain.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification implements Specification<Product> {

    private static final long serialVersionUID = 1L;

    private String field;
    private String operator;
    private Object value;

    public ProductSpecification(String field, String operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (operator.equalsIgnoreCase("LIKE")) {
            if (field.equalsIgnoreCase("category.name")) {
                return builder.like(root.get("category").get("name"), "%" + value.toString() + "%");
            } else {
                return builder.like(root.get(field), "%" + value.toString() + "%");
            }
        }
        return null;
    }
}
