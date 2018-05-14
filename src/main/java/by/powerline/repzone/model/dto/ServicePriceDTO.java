package by.powerline.repzone.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ServicePriceDTO {
    private Long id;
    private Long brandId;
    private Long modelId;
    private Long categoryId;
    private ServiceDTO service;
    private Integer price;
}
