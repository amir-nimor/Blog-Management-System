package ir.maktabsharif.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostDao extends BaseModel<Long>{

    private String title;

    private String description;


    @ManyToOne
    private UserDao userDao;



}
