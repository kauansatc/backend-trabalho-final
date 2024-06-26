package backend.medapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.medapi.dtos.MedicineDto;
import backend.medapi.dtos.MedicineDtoOpt;
import backend.medapi.services.MedicineService;
import jakarta.validation.Valid;

@RestController
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    @GetMapping("/medicines")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        try {
            var list = medicineService.getAll(page, size);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/medicines")
    public ResponseEntity<?> add(@RequestBody @Valid MedicineDto body,
            @RequestParam(defaultValue = "false") Boolean handleNew) {
        try {
            medicineService.add(body, handleNew);
            return ResponseEntity.ok("Medicine added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/medicines/{name}")
    public ResponseEntity<?> delete(@PathVariable String name) {
        try {
            medicineService.delete(name);
            return ResponseEntity.ok("Medicine deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/medicines/{name}")
    public ResponseEntity<?> update(@PathVariable String name, @RequestBody @Valid MedicineDtoOpt body,
            @RequestParam(defaultValue = "false") Boolean handleNew) {
        try {
            medicineService.update(name, body, handleNew);
            return ResponseEntity.ok("Medicine updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
