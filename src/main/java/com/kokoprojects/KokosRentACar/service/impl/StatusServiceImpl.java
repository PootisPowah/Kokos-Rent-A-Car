package com.kokoprojects.KokosRentACar.service.impl;

import com.kokoprojects.KokosRentACar.entity.Status;
import com.kokoprojects.KokosRentACar.entity.dto.StatusDTO;
import com.kokoprojects.KokosRentACar.entity.dto.mapper.StatusMapper;
import com.kokoprojects.KokosRentACar.repository.StatusRepository;
import com.kokoprojects.KokosRentACar.service.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;
    private final StatusMapper statusMapper;

    public StatusServiceImpl(StatusRepository statusRepository, StatusMapper statusMapper) {
        this.statusRepository = statusRepository;
        this.statusMapper = statusMapper;
    }

    @Override
    public StatusDTO getStatusById(long id) {
        Status status = statusRepository.findById(id).orElseThrow(()-> new RuntimeException("No status found with id: " + id));
        return statusMapper.toStatusDTO(status);
    }

    @Override
    public List<StatusDTO> getAllStatuses() {
        List<Status> statuses = statusRepository.findAll();
        return statuses.stream().map(statusMapper::toStatusDTO).collect(Collectors.toList());
    }

    @Override
    public StatusDTO createStatus(StatusDTO statusDTO) {
        Status status = statusMapper.toStatus(statusDTO);
        Status savedStatus = statusRepository.save(status);
        return statusMapper.toStatusDTO(savedStatus);
    }

    @Override
    public StatusDTO updateStatus(StatusDTO statusDTO, long id) {
        Status status = statusRepository.findById(id).orElseThrow(()-> new RuntimeException("No status found with id: " + id));
        statusMapper.updateStatusToDTO(statusDTO,status);
        Status savedStatus = statusRepository.save(status);
        return statusMapper.toStatusDTO(savedStatus);
    }

    @Override
    public void deleteStatusById(long id) {
        statusRepository.deleteById(id);
    }
}
