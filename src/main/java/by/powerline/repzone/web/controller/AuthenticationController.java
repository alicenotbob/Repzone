package by.powerline.repzone.web.controller;

import by.powerline.repzone.exception.auth.UserNotFoundException;
import by.powerline.repzone.model.dto.ErrorInfoDTO;
import by.powerline.repzone.model.dto.LoginRequestDTO;
import by.powerline.repzone.model.dto.LoginResponseDTO;
import by.powerline.repzone.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return authenticationService.login(loginRequestDTO);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({UserNotFoundException.class, BadCredentialsException.class})
    public ErrorInfoDTO usernameNotFound(Exception exception) {
        return new ErrorInfoDTO(exception);
    }
}
