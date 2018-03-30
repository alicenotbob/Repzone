package by.powerline.repzone.service.impl;

import by.powerline.repzone.model.db.Service;
import by.powerline.repzone.model.dto.RegistrationRequestDTO;
import by.powerline.repzone.model.dto.RegistrationResponseDTO;
import by.powerline.repzone.model.dto.RegistrationResponseDTO.regRespType;
import by.powerline.repzone.repository.ServiceRepository;
import by.powerline.repzone.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final ServiceRepository serviceRepository;
    private final ModelMapper mapper;

    @Override
    public RegistrationResponseDTO register(RegistrationRequestDTO registrationRequestDTO) {
        Service service = serviceRepository.findServiceByEmail(registrationRequestDTO.getEmail());
        if (service != null) {
            return new RegistrationResponseDTO(regRespType.SUCH_EMAIL_EXIST);
        }
        service = mapper.map(registrationRequestDTO, Service.class);
        serviceRepository.save(service);
        return new RegistrationResponseDTO(regRespType.OK);
    }
}
