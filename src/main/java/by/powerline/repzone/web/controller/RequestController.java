package by.powerline.repzone.web.controller;

import by.powerline.repzone.model.db.Brand;
import by.powerline.repzone.model.db.Category;
import by.powerline.repzone.model.db.Region;
import by.powerline.repzone.model.dto.ErrorInfoDTO;
import by.powerline.repzone.model.dto.ModelDTO;
import by.powerline.repzone.model.dto.RequestDTO;
import by.powerline.repzone.model.dto.ServiceDTO;
import by.powerline.repzone.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class RequestController {

    private final ServiceModelService serviceModelService;
    private final RequestService requestService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final CategoryService categoryService;

    @PostMapping("/leaveRequest")
    public Boolean leaveRequest(@RequestBody RequestDTO requestDTO) {
        return requestService.leaveRequest(requestDTO);
    }

    @GetMapping("/getRegions")
    public List<Region> getRegions() {
        return requestService.getRegions();
    }

    @GetMapping("/getBrands")
    public List<Brand> getBrands() {
        return brandService.getBrands();
    }

    @GetMapping("/getCategories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/getModels/{brandId}")
    public List<ModelDTO> getModelsByBrand(@PathVariable Long brandId) {
        return modelService.getModelsByBrandId(brandId);
    }

    @PostMapping("/searchServices")
    public List<ServiceDTO> searchServices(@RequestBody RequestDTO requestDTO) {
        return serviceModelService.searchServices(requestDTO);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ErrorInfoDTO internalServerError(Exception ex) {
        return new ErrorInfoDTO(ex);
    }
}
