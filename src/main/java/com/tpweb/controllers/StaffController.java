package com.tpweb.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tpweb.services.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.tpweb.models.Staff;
import com.tpweb.services.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StaffController {

    @Autowired
    IStaffService staffService;

    @GetMapping("/staffs")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Staff> getAllStaff() {
        return staffService.findAllStaffs();
    }

    @GetMapping("/staff/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Staff getStaff(@PathVariable Long id) {
        return staffService.findStaffByID(id);
    }

    @DeleteMapping("/staff/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(staffService.findStaffByID(id));
    }
    @PutMapping("/staff/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Staff editStaff(@PathVariable Long id, @Valid @RequestBody Staff staff) {
        Staff staff1 = staffService.findStaffByID(id);
        if (staff1 != null) {
            staff.setId(staff1.getId());
            return staffService.editStaff(staff);
        }
        return null;
    }

    @PostMapping("/staff")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Staff createStaff(@Valid @RequestBody Staff staff) {
        return staffService.saveStaff(staff);
    }


}

