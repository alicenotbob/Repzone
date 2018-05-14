package by.powerline.repzone.service;

import by.powerline.repzone.model.dto.RequestDTO;
import by.powerline.repzone.model.dto.ServicePriceDTO;

import java.util.List;

public interface ServicePriceService {
    List<ServicePriceDTO> getServicesPrices(RequestDTO dto);
    ServicePriceDTO savePriceElement(ServicePriceDTO dto);
    List<ServicePriceDTO> getPriceElements();
}
