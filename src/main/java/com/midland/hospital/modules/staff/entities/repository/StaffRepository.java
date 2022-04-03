package com.midland.hospital.modules.staff.entities.repository;

import com.midland.hospital.modules.staff.dto.StaffProfileDTO;
import com.midland.hospital.modules.staff.entities.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {

    Staff findByName(String name);

    Staff findByUuid(String uuid);

    @Query(value = "select new com.midland.hospital.modules.staff.dto.StaffProfileDTO(s.id,s.name,s.uuid,s.createdOn) from Staff s order by s.id desc")
    StaffProfileDTO findStaffProfileByUuid(String uuid);



}
