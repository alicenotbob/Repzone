package by.powerline.repzone.model.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "request")
@Getter
@Setter
public class Request {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Region region;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Model model;

    @ManyToOne
    private Category category;

    @Column
    private String customerPhone;
}
