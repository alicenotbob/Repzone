package by.powerline.repzone.web.controller;

import by.powerline.repzone.model.dto.RequestDTO;
import by.powerline.repzone.model.dto.ServicePriceDTO;
import by.powerline.repzone.service.ServicePriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServicePriceController {

    private final ServicePriceService servicePriceService;

    @PostMapping(value = "/searchServicePrices")
    public List<ServicePriceDTO> getServicePrice(@RequestBody RequestDTO dto) {
        return servicePriceService.getServicesPrices(dto);
    }

    @PostMapping(value = "/savePriceElement")
    public ServicePriceDTO savePriceElement(@RequestBody ServicePriceDTO dto) {
        return servicePriceService.savePriceElement(dto);
    }

    @GetMapping(value = "/getPriceElements")
    public List<ServicePriceDTO> getPriceElements() {
        return servicePriceService.getPriceElements();
    }
}
