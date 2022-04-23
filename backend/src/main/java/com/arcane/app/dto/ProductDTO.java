package com.arcane.app.dto;
import java.time.LocalDate;
import java.util.List;


public class ProductDTO {
    private Long id;

    private String name;

    private String content;

    private Float price;

    private List<ImageDTO> images ;

    private List<OrderDetailsDTO> orderDetails;

    private ProductCategoryDTO category;

    private List<TagDTO> tags;

    static class ProductCategoryDTO{
        private Long id;
        private String name;
        private LocalDate createdAt;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
        }
    }

    static class ImageDTO{
        private Long id;

        private String name;

        private String pathImage;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPathImage() {
            return pathImage;
        }

        public void setPathImage(String pathImage) {
            this.pathImage = pathImage;
        }
    }

    static class OrderDetailsDTO{
        private Long id;

        private Integer amount;

        private Float price;

        private Integer discountValue;

        private String discountCode;

        private Float total;

        private LocalDate createdAt;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }

        public Integer getDiscountValue() {
            return discountValue;
        }

        public void setDiscountValue(Integer discountValue) {
            this.discountValue = discountValue;
        }

        public String getDiscountCode() {
            return discountCode;
        }

        public void setDiscountCode(String discountCode) {
            this.discountCode = discountCode;
        }

        public Float getTotal() {
            return total;
        }

        public void setTotal(Float total) {
            this.total = total;
        }

        public LocalDate getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
        }
    }

    static class TagDTO{
        private Long id;

        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void listTags(List<TagDTO> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Float getPrice() {
        return price;
    }

    public List<TagDTO> getTags() {
        return tags;
    }


    public List<ImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ImageDTO> images) {
        this.images = images;
    }

    public List<OrderDetailsDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public ProductCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryDTO category) {
        this.category = category;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }
}
