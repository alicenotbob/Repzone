package by.powerline.repzone.service;

import by.powerline.repzone.model.dto.RegistrationResponseDTO;
import by.powerline.repzone.model.dto.ServiceDTO;

public interface RegistrationService {
    RegistrationResponseDTO register(ServiceDTO serviceDTO);
}
