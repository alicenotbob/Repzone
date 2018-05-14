package by.powerline.repzone.service.impl;

import by.powerline.repzone.model.db.ServicePrice;
import by.powerline.repzone.model.dto.RequestDTO;
import by.powerline.repzone.model.dto.ServicePriceDTO;
import by.powerline.repzone.repository.ModelRepository;
import by.powerline.repzone.repository.ServiceModelRepository;
import by.powerline.repzone.repository.ServicePriceRepozitory;
import by.powerline.repzone.security.SecurityHelper;
import by.powerline.repzone.security.model.JwtUserDetails;
import by.powerline.repzone.service.ServicePriceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicePriceServiceImpl implements ServicePriceService {

    private final ServicePriceRepozitory servicePriceRepozitory;
    private final ServiceModelRepository serviceModelRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ServicePriceDTO> getServicesPrices(RequestDTO dto) {
        List<ServicePrice> servicesPrices = servicePriceRepozitory.findAllByModelIdAndCategoryId(dto.getModelId(), dto.getCategoryId());
        List<ServicePriceDTO> servicePriceDTOList = new ArrayList<>(servicesPrices.size());
        for (ServicePrice servicePrice : servicesPrices) {
            servicePriceDTOList.add(modelMapper.map(servicePrice, ServicePriceDTO.class));
        }
        return servicePriceDTOList;
    }

    @Override
    public ServicePriceDTO savePriceElement(ServicePriceDTO dto) {
        ServicePrice servicePrice = modelMapper.map(dto, ServicePrice.class);
        Authentication authentication = SecurityHelper.getAuthenticationWithCheck();
        JwtUserDetails userDetails = ((JwtUserDetails)authentication.getDetails());
        servicePrice.setService(serviceModelRepository.findOne(userDetails.getId()));
        ServicePrice check = servicePriceRepozitory.save(servicePrice);
        return check == null ? null : modelMapper.map(check, ServicePriceDTO.class);
    }

    @Override
    public List<ServicePriceDTO> getPriceElements() {
        Authentication authentication = SecurityHelper.getAuthenticationWithCheck();
        JwtUserDetails userDetails = ((JwtUserDetails)authentication.getDetails());
        List<ServicePrice> servicePrices = servicePriceRepozitory.findAllByServiceId(userDetails.getId());
        List<ServicePriceDTO> servicePriceDTOList = new ArrayList<>(servicePrices.size());
        for (ServicePrice servicePrice : servicePrices) {
            ServicePriceDTO dto = modelMapper.map(servicePrice, ServicePriceDTO.class);
            dto.setBrandId(modelRepository.findOne(dto.getModelId()).getBrand().getId());
            servicePriceDTOList.add(dto);
        }
        return servicePriceDTOList;
    }
}
