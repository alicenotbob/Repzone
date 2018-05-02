package by.powerline.repzone.service;

import by.powerline.repzone.model.dto.RequestDTO;
import by.powerline.repzone.model.dto.ServiceDTO;

import java.util.List;

public interface ServiceModelService {
    List<ServiceDTO> searchServices(RequestDTO requestDTO);
}
