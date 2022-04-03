package com.PatManSystem.main.Repository;


import com.PatManSystem.main.Models.Newpatientconsult;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewpatientconsultRepository extends JpaRepository<Newpatientconsult, Integer> {
    Newpatientconsult findNewpatientconsultById(Integer Id);
    List<Newpatientconsult> findNewpatientconsultByUli(Patientinformation patientinformation);
}