package by.powerline.repzone.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ServiceDTO {
    private Long id;
    private String serviceName;
    private String password;
    private String email;
    private String serviceDescription;
    private String serviceTimeOpen;
    private String servicePhones;
    private String region;
    private Boolean officialService;
    private Boolean warranty;
    private Boolean courierAvailability;
    private Boolean legalEntityService;
}
