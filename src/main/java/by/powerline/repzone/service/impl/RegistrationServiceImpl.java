package by.powerline.repzone.service.impl;

import by.powerline.repzone.exception.auth.UserAlreadyExistException;
import by.powerline.repzone.model.db.ServiceModel;
import by.powerline.repzone.model.dto.RegistrationResponseDTO;
import by.powerline.repzone.model.dto.RegistrationResponseDTO.regRespType;
import by.powerline.repzone.model.dto.ServiceDTO;
import by.powerline.repzone.repository.ServiceRepository;
import by.powerline.repzone.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final ServiceRepository serviceRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder encoder;

    @Override
    public RegistrationResponseDTO register(ServiceDTO serviceDTO) {
        ServiceModel serviceModel = serviceRepository.findServiceByEmail(serviceDTO.getEmail());
        if (serviceModel != null) {
            throw new UserAlreadyExistException();
        }
        serviceModel = mapper.map(serviceDTO, ServiceModel.class);
        serviceModel.setPassword(encoder.encode(serviceModel.getPassword()));
        serviceRepository.save(serviceModel);
        return new RegistrationResponseDTO(regRespType.OK);
    }
}
