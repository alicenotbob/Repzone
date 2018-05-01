package by.powerline.repzone.service.impl;

import by.powerline.repzone.model.db.Model;
import by.powerline.repzone.model.dto.ModelDTO;
import by.powerline.repzone.repository.ModelRepository;
import by.powerline.repzone.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ModelDTO> getModelsByBrandId(Long brandId) {
        List<Model> models = modelRepository.findAllByBrandId(brandId);
        List<ModelDTO> modelDTOList = new ArrayList<>(models.size());
        for (Model model : models) {
            modelDTOList.add(modelMapper.map(model, ModelDTO.class));
        }
        return modelDTOList;
    }
}
