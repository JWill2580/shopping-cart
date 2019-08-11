/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotNegative;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author wiljo912
 */
public class Product {
    private String productID;
    @NotNull(message = "Name must be provided.")
    //@NotBlank(message = "Name must be provided.")
    @Length(min=2, message="Name must contain at least two characters.")
    private  String name;
    private  String description;
    private String category;
    @NotNull(message = "Price must be provided.")
    @NotNegative(message = "Price must be zero or greater.")
    private BigDecimal listPrice;
    private  BigDecimal quantityInStock;

    public Product() {
    }
    
    public Product(String ID, String name, String description, String category, BigDecimal listPrice, BigDecimal quantityInStock) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.category = category;
        this.listPrice = listPrice;
        this.quantityInStock = quantityInStock;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productId) {
        this.productID = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public BigDecimal getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(BigDecimal quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "ID = " + productID + ", Name = " + name + ", Description = " + 
                description + ", Category = " + category + ", $" + listPrice 
                + ", Quantity In Stock = " + quantityInStock;
    }
    
    
}
