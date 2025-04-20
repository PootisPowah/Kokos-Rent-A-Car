package com.kokoprojects.KokosRentACar.controller;

import com.kokoprojects.KokosRentACar.entity.dto.ExtraDTO;
import com.kokoprojects.KokosRentACar.service.ExtraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extras")
public class ExtraController {

    private final ExtraService extraService;

    public ExtraController(ExtraService extraService) {
        this.extraService = extraService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtraDTO> getExtraById(@PathVariable long id) {
        ExtraDTO extra = extraService.getExtraById(id);
        return ResponseEntity.ok(extra);
    }

    @GetMapping
    public ResponseEntity<List<ExtraDTO>> getAllExtra() {
        List<ExtraDTO> extrasList = extraService.getAllExtras();
        return ResponseEntity.ok(extrasList);
    }

    @PostMapping
    public ResponseEntity<ExtraDTO> createExtra(@RequestBody ExtraDTO extraDTO) {
        ExtraDTO extra = extraService.createExtra(extraDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(extra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExtraDTO> updateExtra(@RequestBody ExtraDTO extraDTO, @PathVariable long id){
        ExtraDTO extra = extraService.updateExtra(extraDTO, id);
        return ResponseEntity.ok(extra);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExtra(@PathVariable long id) {
        extraService.deleteExtraById(id);
        return ResponseEntity.noContent().build();
    }
}
