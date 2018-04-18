package by.powerline.repzone.web.controller;

import by.powerline.repzone.model.dto.RequestDTO;
import by.powerline.repzone.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping("/leaveRequest")
    public String leaveRequest(@RequestBody RequestDTO requestDTO) {
        return requestService.leaveRequest(requestDTO);
    }
}
