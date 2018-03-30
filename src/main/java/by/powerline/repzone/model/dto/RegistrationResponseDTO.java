package by.powerline.repzone.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@Component
public class RegistrationResponseDTO {
    public enum regRespType {
        OK,
        SUCH_EMAIL_EXIST,
        REGISTRATION_ERROR
    }
    private regRespType type;
}
