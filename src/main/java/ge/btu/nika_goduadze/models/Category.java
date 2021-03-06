package ge.btu.nika_goduadze.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    //    @JsonIgnore
    @ManyToMany(mappedBy = "categories",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Movie> posts=new ArrayList<>();
}