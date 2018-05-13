package by.powerline.repzone.model.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "services_prices")
@Getter
@Setter
public class ServicePrice {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Model model;

    @ManyToOne
    private Category category;

    @ManyToOne
    private ServiceModel service;

    @Column
    private Integer price;
}
