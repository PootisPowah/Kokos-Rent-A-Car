package com.kokoprojects.KokosRentACar.controller;

import com.kokoprojects.KokosRentACar.entity.dto.StatusDTO;
import com.kokoprojects.KokosRentACar.service.StatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statuses")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDTO> getStatus(@PathVariable long id) {
        StatusDTO status = statusService.getStatusById(id);
        return ResponseEntity.ok(status);
    }

    @GetMapping
    public ResponseEntity<List<StatusDTO>> getStatus() {
        List<StatusDTO> statusList = statusService.getAllStatuses();
        return ResponseEntity.ok(statusList);
    }


    @PostMapping
    public ResponseEntity<StatusDTO> createStatus(@RequestBody StatusDTO statusDTO){
        StatusDTO status = statusService.createStatus(statusDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDTO> updateStatus(@RequestBody StatusDTO statusDTO, @PathVariable long id){
        StatusDTO status = statusService.updateStatus(statusDTO, id);
        return ResponseEntity.ok(status);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable long id){
        statusService.deleteStatusById(id);
        return ResponseEntity.noContent().build();
    }
}
