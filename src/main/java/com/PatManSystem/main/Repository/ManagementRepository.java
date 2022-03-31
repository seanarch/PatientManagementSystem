package com.PatManSystem.main.Repository;


import com.PatManSystem.main.Models.Management;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagementRepository extends JpaRepository<Management, Long> {
    Management findManagementById(Long Id);
    List<Management> findManagementByUli(Long uli);
}