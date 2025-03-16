package EJB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "\"Products\"")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Products_id_gen")
    @SequenceGenerator(name = "Products_id_gen", sequenceName = "Products_Id_seq", allocationSize = 1)
    @Column(name = "\"Id\"", nullable = false)
    private Integer id;

    @NotNull
    @Lob
    @Column(name = "\"ProductName\"", nullable = false)
    private String productName;

    @NotNull
    @Column(name = "\"Price\"", nullable = false)
    private Float price;

    @NotNull
    @Column(name = "\"Quantity\"", nullable = false)
    private Integer quantity;

    @NotNull
    @Lob
    @Column(name = "\"Description\"", nullable = false)
    private String description;

    @NotNull
    @Lob
    @Column(name = "\"ImagePath\"", nullable = false)
    private String imagePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}