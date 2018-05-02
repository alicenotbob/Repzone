package by.powerline.repzone.service.impl;

import by.powerline.repzone.exception.auth.AuthenticationFailedException;
import by.powerline.repzone.exception.auth.UserNotFoundException;
import by.powerline.repzone.model.db.ServiceModel;
import by.powerline.repzone.model.dto.LoginRequestDTO;
import by.powerline.repzone.model.dto.LoginResponseDTO;
import by.powerline.repzone.model.dto.ServiceDTO;
import by.powerline.repzone.repository.ServiceModelRepository;
import by.powerline.repzone.security.model.JwtUserDetails;
import by.powerline.repzone.security.service.AuthenticationHelper;
import by.powerline.repzone.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Objects;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationHelper authenticationHelper;
    private final ServiceModelRepository serviceModelRepository;
    private final ModelMapper mapper;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        UsernamePasswordAuthenticationToken authRequest = makeAuthToken(loginRequestDTO);
        final Authentication authResult = this.authenticationManager.authenticate(authRequest);
        if (authResult.isAuthenticated()) {
            return makeResponse(authResult);
        } else {
            throw new AuthenticationFailedException("Authentication failed.");
        }
    }

    private UsernamePasswordAuthenticationToken makeAuthToken(final LoginRequestDTO loginRequestDTO) {
        String username = Optional.ofNullable(loginRequestDTO.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Email should be passed"));
        String password = Optional.ofNullable(loginRequestDTO.getPassword())
                .orElseThrow(() -> new BadCredentialsException("Password should be passed"));
        return new UsernamePasswordAuthenticationToken(username, password);
    }

    private LoginResponseDTO makeResponse(final Authentication authResult) {
        ServiceDTO serviceDTO = getAuthUserDto(authResult);
        String token = this.authenticationHelper.generateToken(serviceDTO.getId());
        return new LoginResponseDTO(token, serviceDTO);
    }

    private ServiceDTO getAuthUserDto(final Authentication authResult) {
        JwtUserDetails userDetails = (JwtUserDetails) authResult.getPrincipal();
        ServiceModel serviceModel = serviceModelRepository.getOne(userDetails.getId());
        ServiceDTO dto = mapper.map(serviceModel, ServiceDTO.class);
        if(Objects.isNull(dto)) {
            throw new UserNotFoundException("Such serviceModel is not registered.");
        }
        return dto;
    }
}
