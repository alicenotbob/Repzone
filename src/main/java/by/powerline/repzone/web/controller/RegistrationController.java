package by.powerline.repzone.web.controller;

import by.powerline.repzone.exception.auth.UserAlreadyExistException;
import by.powerline.repzone.model.dto.RegistrationResponseDTO;
import by.powerline.repzone.model.dto.RegistrationResponseDTO.regRespType;
import by.powerline.repzone.model.dto.ServiceDTO;
import by.powerline.repzone.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping(path = "/register")
    public RegistrationResponseDTO register(@RequestBody ServiceDTO serviceDTO) {
        return registrationService.register(serviceDTO);
    }

    @ExceptionHandler({UserAlreadyExistException.class})
    public RegistrationResponseDTO userAlreadyExist(Exception ex) {
        return new RegistrationResponseDTO(regRespType.SUCH_EMAIL_EXIST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public RegistrationResponseDTO unknownError() {
        return new RegistrationResponseDTO(regRespType.REGISTRATION_ERROR);
    }
}
