package by.powerline.repzone.service.impl;

import by.powerline.repzone.model.db.Region;
import by.powerline.repzone.model.db.Request;
import by.powerline.repzone.model.dto.RequestDTO;
import by.powerline.repzone.repository.RegionRepository;
import by.powerline.repzone.repository.RequestRepository;
import by.powerline.repzone.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReqeustServiceImpl implements RequestService {

    private final RegionRepository regionRepository;
    private final RequestRepository requestRepository;
    private final ModelMapper modelMapper;

    @Override
    public Boolean leaveRequest(RequestDTO requestDTO) {
        Request request = modelMapper.map(requestDTO, Request.class);
        Request check = requestRepository.save(request);
        return Objects.nonNull(check);
    }

    @Override
    public List<Region> getRegions() {
        return regionRepository.findAll();
    }
}
