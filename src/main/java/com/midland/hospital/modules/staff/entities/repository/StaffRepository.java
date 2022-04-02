package com.midland.hospital.modules.staff.entities.repository;

import com.midland.hospital.modules.staff.entities.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {

    
}
