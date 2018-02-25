package by.powerline.repzone.model.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 20.02.2018 21:21
 */
@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private UserRole role;
}
