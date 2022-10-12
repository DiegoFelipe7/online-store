package co.com.sofka.onlinestore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "products")
public class Products {
    @Id
    private String id;
    private String name;
    private String type_product;
    private String color;
    private Integer quantity;
    private Double price;
    private Double total;
}
