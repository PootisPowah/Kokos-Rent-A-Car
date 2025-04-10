package com.kokoprojects.KokosRentACar.service.impl;

import com.kokoprojects.KokosRentACar.entity.Office;
import com.kokoprojects.KokosRentACar.entity.dto.OfficeDTO;
import com.kokoprojects.KokosRentACar.entity.dto.mapper.OfficeMapper;
import com.kokoprojects.KokosRentACar.repository.OfficeRepository;
import com.kokoprojects.KokosRentACar.service.OfficeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;
    private final OfficeMapper officeMapper;

    public OfficeServiceImpl(OfficeRepository officeRepository, OfficeMapper officeMapper) {
        this.officeRepository = officeRepository;
        this.officeMapper = officeMapper;
    }

    public OfficeDTO getOfficeById(long id) {
        Office office = officeRepository.findById(id).orElseThrow(()->new RuntimeException("Office with id " + id + " not found"));
        return officeMapper.entityToOfficeDto(office);
    }

    public List<OfficeDTO> getAllOffices(){
        List<Office> offices = officeRepository.findAll();
        return offices.stream().map(officeMapper::entityToOfficeDto).collect(Collectors.toList());
    }

    public OfficeDTO createOffice(OfficeDTO officeDTO) {
        Office office = officeMapper.officeDtoToEntity(officeDTO);
        Office savedOffice = officeRepository.save(office);
        return officeMapper.entityToOfficeDto(savedOffice);
    }

    public OfficeDTO updateOffice(OfficeDTO officeDTO, long id) {
        Office office = officeRepository.findById(id).orElseThrow(()->new RuntimeException("Office with id " + id + " not found"));
        officeMapper.updateOfficeDTO(officeDTO,office);
        Office savedOffice = officeRepository.save(office);
        return officeMapper.entityToOfficeDto(savedOffice);
    }

    @Override
    public void deleteOffice(long id) {
        officeRepository.deleteById(id);
    }
}
