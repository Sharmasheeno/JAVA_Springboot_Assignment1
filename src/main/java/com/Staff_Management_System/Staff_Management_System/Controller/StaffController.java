package com.Staff_Management_System.Staff_Management_System.Controller;

import com.Staff_Management_System.Staff_Management_System.Model.Staff;
import com.Staff_Management_System.Staff_Management_System.Service.StaffService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/staffs/")
public class StaffController {

    private final StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    @GetMapping("all")
    public Collection<Staff> getAllStaffs() {
        return service.getAllStaffs();
    }

    @GetMapping("{id}")
    public Staff getStaffById(@PathVariable Long id) {
        return service.getStaffById(id);
    }

    @PostMapping
    public ResponseEntity<Staff> saveStaff(@RequestBody Staff newStaff) {
        Staff savedStaff = service.saveStaff(newStaff);
        HttpHeaders headers = new HttpHeaders();
        headers.add("created", "staff created with ResponseEntity");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(savedStaff);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Staff newStaff) {
        service.updateStaff(id, newStaff);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStaff(id);
    }
}