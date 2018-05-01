package by.powerline.repzone.service;

import by.powerline.repzone.model.dto.ModelDTO;

import java.util.List;

public interface ModelService {
    List<ModelDTO> getModelsByBrandId(Long brandId);
}
