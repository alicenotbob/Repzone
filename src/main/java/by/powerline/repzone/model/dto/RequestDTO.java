package by.powerline.repzone.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class RequestDTO {
    private Long id;
    private Long regionId;
    private Long brandId;
    private Long modelId;
    private Long categoryId;
    private String customerPhone;
}
