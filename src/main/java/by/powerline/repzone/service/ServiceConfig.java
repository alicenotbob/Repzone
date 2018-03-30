package by.powerline.repzone.service;

import by.powerline.repzone.model.dto.RegistrationResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public RegistrationResponseDTO.regRespType regRespTypeBean() {
        return RegistrationResponseDTO.regRespType.OK;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
