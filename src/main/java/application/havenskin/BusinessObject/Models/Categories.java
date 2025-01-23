package application.havenskin.BusinessObject.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Categories")
@Data
public class Categories {
    @Id
    @Column(name = "category_id", length = 50)
    private String categoryId;

    @Column(name = "category_name", length = 50)
    private String categoryName;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "usage_instruction", length = 255)
    private String usageInstruction;

    @OneToMany(mappedBy = "categories")
    private List<Products> products;


}
