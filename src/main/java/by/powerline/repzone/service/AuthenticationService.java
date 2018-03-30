package by.powerline.repzone.service;

import by.powerline.repzone.model.dto.LoginRequestDTO;
import by.powerline.repzone.model.dto.LoginResponseDTO;

public interface AuthenticationService {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
