package by.powerline.repzone.model.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 20.02.2018 21:21
 */
@Entity
@Table(name = "services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String serviceName;

    @Column
    private String password;

    @Column(unique = true)
    private String email;

    @Column
    private String serviceDescription;

    @Column
    private String serviceTimeOpen;

    @Column
    private String servicePhones;

    @OneToOne
    private Region region;

    @Column
    private Boolean officialService;

    @Column
    private Boolean warranty;

    @Column
    private Boolean courierAvailability;

    @Column
    private Boolean legalEntityService;
}
