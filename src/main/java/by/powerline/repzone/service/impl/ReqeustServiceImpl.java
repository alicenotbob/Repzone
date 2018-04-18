package by.powerline.repzone.service.impl;

import by.powerline.repzone.model.db.Request;
import by.powerline.repzone.model.dto.RequestDTO;
import by.powerline.repzone.repository.RequestRepository;
import by.powerline.repzone.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReqeustServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final ModelMapper modelMapper;

    @Override
    public String leaveRequest(RequestDTO requestDTO) {
        Request request = modelMapper.map(requestDTO, Request.class);
        Request check = requestRepository.save(request);
        return Objects.isNull(check) ? "NEOK" : "OK";
    }
}
