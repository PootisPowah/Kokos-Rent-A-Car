package com.kokoprojects.KokosRentACar.controller;

import com.kokoprojects.KokosRentACar.entity.dto.OfficeDTO;
import com.kokoprojects.KokosRentACar.service.OfficeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offices")
public class OfficeController {
    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfficeDTO> getOfficeById(@PathVariable long id) {
        OfficeDTO officeDTO = officeService.getOfficeById(id);
        return ResponseEntity.ok(officeDTO);
    }

    @GetMapping
    public ResponseEntity<List<OfficeDTO>> getOffices() {
        List<OfficeDTO> officeList = officeService.getAllOffices();
        return ResponseEntity.ok(officeList);
    }

    @PostMapping
    public ResponseEntity<OfficeDTO> createOffice(@Valid @RequestBody OfficeDTO officeDTO) {
        OfficeDTO office = officeService.createOffice(officeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(office);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfficeDTO> updateOffice(@RequestBody OfficeDTO officeDTO, @PathVariable long id){
        OfficeDTO office = officeService.updateOffice(officeDTO, id);
        return ResponseEntity.ok(office);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffice(@PathVariable long id) {
        officeService.deleteOffice(id);
        return ResponseEntity.noContent().build();
    }
}
