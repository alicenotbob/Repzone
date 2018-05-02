package by.powerline.repzone.service.impl;

import by.powerline.repzone.model.db.ServiceModel;
import by.powerline.repzone.model.dto.RequestDTO;
import by.powerline.repzone.model.dto.ServiceDTO;
import by.powerline.repzone.repository.ServiceModelRepository;
import by.powerline.repzone.service.ServiceModelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceModelServiceImpl implements ServiceModelService {

    private final ServiceModelRepository serviceModelRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ServiceDTO> searchServices(RequestDTO requestDTO) {
        List<ServiceModel> serviceModels =  serviceModelRepository.findAllByRegionId(requestDTO.getRegionId());
        List<ServiceDTO> servicesDTO = new ArrayList<>(serviceModels.size());
        for (ServiceModel serviceModel: serviceModels) {
            servicesDTO.add(modelMapper.map(serviceModel, ServiceDTO.class));
        }
        return servicesDTO;
    }
}
