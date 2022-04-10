package com.PatManSystem.main.Repository;

import com.PatManSystem.main.Models.Childpugh;
import com.PatManSystem.main.Models.Patientinformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildpughRepository extends JpaRepository<Childpugh, Integer> {
	List<Childpugh> findByUli(Patientinformation patientinformation);
}