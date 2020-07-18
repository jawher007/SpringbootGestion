package com.tpweb.services;

import java.util.List;

import com.tpweb.models.Staff;

public interface IStaffService {

    Staff saveStaff(Staff staff);

    List<Staff> findAllStaffs();


    Staff findStaffByID(Long id);
    Staff editStaff(Staff staff);

    void deleteStaff(Staff staff);
}