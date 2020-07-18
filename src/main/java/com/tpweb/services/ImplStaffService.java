package com.tpweb.services;

import java.util.List;

import com.tpweb.models.Staff;
import com.tpweb.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplStaffService implements IStaffService {

    @Autowired
    StaffRepository repository;

    @Override
    public Staff saveStaff(Staff staff) {
        // TODO Auto-generated method stub
        return repository.save(staff);
    }
    @Override
    public Staff editStaff(Staff staff) {
        return repository.save(staff);
    }

    @Override
    public List<Staff> findAllStaffs() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    public Staff findStaffByID(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteStaff(Staff staff) {
        repository.delete(staff);
    }


}
