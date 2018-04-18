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
    private Brand brand;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Model model;

    @ManyToOne
    private Region region;

    @Column
    private String customerPhone;
}
