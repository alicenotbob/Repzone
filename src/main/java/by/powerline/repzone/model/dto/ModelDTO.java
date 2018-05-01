package by.powerline.repzone.model.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ModelDTO {
    private Long id;
    private String name;
}
