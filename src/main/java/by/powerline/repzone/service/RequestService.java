package by.powerline.repzone.service;

import by.powerline.repzone.model.db.Region;
import by.powerline.repzone.model.dto.RequestDTO;

import java.util.List;

public interface RequestService {
    Boolean leaveRequest(RequestDTO requestDTO);
    List<Region> getRegions();
}
