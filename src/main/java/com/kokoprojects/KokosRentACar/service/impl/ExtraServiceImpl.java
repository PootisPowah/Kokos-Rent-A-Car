package com.kokoprojects.KokosRentACar.service.impl;

import com.kokoprojects.KokosRentACar.entity.Extra;
import com.kokoprojects.KokosRentACar.entity.dto.ExtraDTO;
import com.kokoprojects.KokosRentACar.entity.dto.mapper.ExtrasMapper;
import com.kokoprojects.KokosRentACar.repository.ExtraRepository;
import com.kokoprojects.KokosRentACar.service.ExtraService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtraServiceImpl implements ExtraService {

    private final ExtraRepository extraRepository;
    private final ExtrasMapper extrasMapper;

    public ExtraServiceImpl(ExtraRepository extraRepository, ExtrasMapper extrasMapper) {
        this.extraRepository = extraRepository;
        this.extrasMapper = extrasMapper;
    }

    @Override
    public ExtraDTO getExtraById(long id) {
        Extra extra = extraRepository.findById(id).orElseThrow(()-> new RuntimeException("Extra with id: " + id + " not found"));
        return extrasMapper.entityToDTO(extra);
    }

    @Override
    public List<ExtraDTO> getAllExtras() {
        List<Extra> extras = extraRepository.findAll();
        return extras.stream().map(extrasMapper::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public ExtraDTO createExtra(ExtraDTO extrasDTO) {
        Extra extra = extrasMapper.DTOtoEntity(extrasDTO);
        Extra savedExtra = extraRepository.save(extra);
        return extrasMapper.entityToDTO(savedExtra);
    }

    @Override
    public ExtraDTO updateExtra(ExtraDTO extrasDTO, long id) {


        Extra extra = extraRepository.findById(id).orElseThrow(()-> new RuntimeException("Extra with id: " + id + " not found"));
        extrasMapper.updateExtraDTO(extrasDTO,extra);
        Extra savedExtra = extraRepository.save(extra);
        return extrasMapper.entityToDTO(savedExtra);
    }

    @Override
    public void deleteExtraById(long id) {
         extraRepository.deleteById(id);
    }
}
