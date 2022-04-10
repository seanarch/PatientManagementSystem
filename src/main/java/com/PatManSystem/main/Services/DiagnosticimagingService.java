package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.DiagnosticimagingDTO;
import com.PatManSystem.main.DTO.DiagnosticimagingDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.DiagnosticimagingMapperImpl;
import com.PatManSystem.main.Mapper.DiagnosticimagingMapperImpl;
import com.PatManSystem.main.Models.Diagnosticimaging;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.DiagnosticimagingRepository;
import com.PatManSystem.main.Repository.TypeofdiagnosticimagingRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiagnosticimagingService {


    private final DiagnosticimagingRepository diagnosticimagingRepository;
    private final TypeofdiagnosticimagingRepository typeofdiagnosticimagingRepository;

    @Autowired
    public DiagnosticimagingService(DiagnosticimagingRepository diagnosticimagingRepository,TypeofdiagnosticimagingRepository typeofdiagnosticimagingRepository){
        this.diagnosticimagingRepository = diagnosticimagingRepository;
        this.typeofdiagnosticimagingRepository = typeofdiagnosticimagingRepository;
    }

    public List<DiagnosticimagingDTO> getDiagnosticimagings(){
        return diagnosticimagingRepository.findAll()
                .stream()
                .map(new DiagnosticimagingMapperImpl()::diagnosticimagingToDiagnosticimagingDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public DiagnosticimagingDTO getDiagnosticimaging(Integer id){
        return new DiagnosticimagingMapperImpl().diagnosticimagingToDiagnosticimagingDTO(diagnosticimagingRepository.findById(id).orElseThrow(() -> new NotFoundException("Diagnosticimaging identified by ID:{"+id+"} was not found.")));
    }

    @SneakyThrows
    public List<DiagnosticimagingDTO> getByULI(Long ULI){

        List<Diagnosticimaging> getDiagnosticimagings = diagnosticimagingRepository.findByUli(new Patientinformation(ULI));

        if(getDiagnosticimagings.isEmpty())
            throw new NotFoundException("Diagnosticimaging identified by ID:{"+ULI+"} was not found.");

        return getDiagnosticimagings.stream()
                .map(new DiagnosticimagingMapperImpl()::diagnosticimagingToDiagnosticimagingDTO)
                .collect(Collectors.toList());

    }

    @SneakyThrows
    public void newDiagnosticimaging(DiagnosticimagingDTO DTO){

        if(DTO.getId() != null && diagnosticimagingRepository.findById(DTO.getId()).isPresent())
            throw new DuplicateFoundException("Diagnosticimaging identified by id:{"+DTO.getId()+"} already exists.");

        diagnosticimagingRepository.save(new DiagnosticimagingMapperImpl().diagnosticimagingDTOToDiagnosticimaging(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteDiagnosticimaging(Integer id){

        diagnosticimagingRepository.findById(id).orElseThrow(() -> new NotFoundException("Diagnosticimaging identified by ID:{"+id+"} was not found."));
        diagnosticimagingRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateDiagnosticimaging(DiagnosticimagingDTO DTO){

        Diagnosticimaging setEntity = diagnosticimagingRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Diagnosticimaging identified by ID:{"+DTO.getId()+"} was not found."));

        if (DTO.getDateDI() != null)
            setEntity.setDateDI(DTO.getDateDI());

        if (DTO.getTypeDIId() != null)
            typeofdiagnosticimagingRepository.findById(DTO.getTypeDIId()).ifPresent(setEntity::setTypeDI);

        if (DTO.getFinding() != null)
            setEntity.setFinding(DTO.getFinding());

        diagnosticimagingRepository.save(setEntity);

    }
}
