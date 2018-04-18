package by.powerline.repzone.model.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "models")
@Getter
@Setter
public class Model {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String value;
}
