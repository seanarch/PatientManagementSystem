package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ManagementDTO;
import com.PatManSystem.main.Mapper.ManagementMapperImpl;
import com.PatManSystem.main.Models.Management;

import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.ManagementRepository;
import com.PatManSystem.main.Repository.TypeofmanagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagementService {


    private final ManagementRepository managementRepository;
    private final TypeofmanagementRepository typeofmanagementRepository;

    @Autowired
    public ManagementService(ManagementRepository managementRepository,
                             TypeofmanagementRepository typeofmanagementRepository){
        this.managementRepository = managementRepository;
        this.typeofmanagementRepository = typeofmanagementRepository;
    }

    //get all the Management and return list of ManagementDTO
    public List<ManagementDTO> getManagements(){
        return managementRepository.findAll()
                .stream()
                .map(management -> {
                    return new ManagementMapperImpl().managementToManagementDTO(management);
                })
                .collect(Collectors.toList());
    }

    //find Mangement entity by id and return ManagementDTO
    public ManagementDTO getManagement(Long id){
        Management getManagement = managementRepository.findManagementById(id);
        if(getManagement == null)
            throw new IllegalStateException("Management identified by ID "+id+" was not found.");

        return new ManagementMapperImpl().managementToManagementDTO(getManagement);
    }

    //find Mangement entity by ULI and return ManagementDTO list
    public List<ManagementDTO> getManagementByULI(Long ULI){
        List<Management> getManagements = managementRepository.findManagementByUli(new Patientinformation(ULI,null,null,null,null,null,null,null));
        if (getManagements == null)
            throw new IllegalStateException("Management identified by ULI "+ULI+" was not found.");

        return getManagements.stream()
                .map(management -> new ManagementMapperImpl().managementToManagementDTO(management))
                        .collect(Collectors.toList());
    }

    //create new Management entity by passing managementDTO
    public void newManagement(ManagementDTO managementDTO){
        if(managementRepository.findManagementById(managementDTO.getId()) != null){
            throw new IllegalStateException("Management identified by ID "+managementDTO.getId() + " already exists. Use Post:Update at /api/management/update instead.");
        }
          managementRepository.save(new ManagementMapperImpl().managementDTOToManagement(managementDTO));
    }

    //delete Management entity by id
    public void deleteManagement(Long id){
        if(managementRepository.findManagementById(id) == null){
            throw new IllegalStateException("Management identified by ID "+id+ " does not exist.");
        }else{
            managementRepository.deleteById(id);
        }
    }

    //update Management entity
    public void updateManagement(ManagementDTO managementDTO){
        Management existingManagement = managementRepository.findManagementById(managementDTO.getId());

        if(existingManagement == null)
            throw new IllegalStateException("Management identified by ID "+managementDTO.getId()+" was not found.");
        else{

            if ( managementDTO.getInterventionId() != null ) {
                typeofmanagementRepository.findById(managementDTO.getInterventionId()).ifPresent(existingManagement::setIntervention);
            }
            // management table's id may not need to be updated once it has been created
            /*
            if ( managementDTO.getId() != null ) {
                existingManagement.setId( managementDTO.getId() );
            }
             */
            if ( managementDTO.getDate() != null ) {
                existingManagement.setDate( managementDTO.getDate() );
            }
            if ( managementDTO.getDetail() != null ) {
                existingManagement.setDetail( managementDTO.getDetail() );
            }
            managementRepository.save(existingManagement);
        }
    }

}
