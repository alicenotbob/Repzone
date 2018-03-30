package by.powerline.repzone.service;

import by.powerline.repzone.model.dto.RegistrationRequestDTO;
import by.powerline.repzone.model.dto.RegistrationResponseDTO;

public interface RegistrationService {
    RegistrationResponseDTO register(RegistrationRequestDTO registrationRequestDTO);
}
