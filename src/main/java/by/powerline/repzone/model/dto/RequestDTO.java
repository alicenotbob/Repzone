package by.powerline.repzone.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class RequestDTO {
    private Long category;
    private Long brand;
    private Long model;
    private Long region;
    private String customerPhone;
}
