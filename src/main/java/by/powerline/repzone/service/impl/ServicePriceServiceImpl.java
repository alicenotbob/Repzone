package by.powerline.repzone.service.impl;

import by.powerline.repzone.model.db.ServicePrice;
import by.powerline.repzone.model.dto.RequestDTO;
import by.powerline.repzone.model.dto.ServicePriceDTO;
import by.powerline.repzone.repository.ServicePriceRepozitory;
import by.powerline.repzone.service.ServicePriceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicePriceServiceImpl implements ServicePriceService {

    private final ServicePriceRepozitory servicePriceRepozitory;
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
}
