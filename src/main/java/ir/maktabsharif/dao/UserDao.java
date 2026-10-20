package ir.maktabsharif.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class UserDao extends BaseModel<Integer>{

    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;

    @OneToMany(mappedBy = "userDao",fetch = FetchType.EAGER)
    private List<PostDao> postDaoList;



}
