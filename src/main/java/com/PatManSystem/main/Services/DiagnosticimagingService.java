package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.DiagnosticimagingDTO;
import com.PatManSystem.main.DTO.DiagnosticimagingDTO;
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
        return new DiagnosticimagingMapperImpl().diagnosticimagingToDiagnosticimagingDTO(diagnosticimagingRepository.findById(id).orElseThrow(() -> new DiagnosticimagingService.DiagnosticimagingNotFound(id)));
    }

    @SneakyThrows
    public List<DiagnosticimagingDTO> getByULI(Long ULI){

        List<Diagnosticimaging> getDiagnosticimagings = diagnosticimagingRepository.findByUli(new Patientinformation(ULI));

        if(getDiagnosticimagings.isEmpty())
            throw new DiagnosticimagingService.DiagnosticimagingNotFound(ULI);

        return getDiagnosticimagings.stream()
                .map(new DiagnosticimagingMapperImpl()::diagnosticimagingToDiagnosticimagingDTO)
                .collect(Collectors.toList());

    }

    @SneakyThrows
    public void newDiagnosticimaging(DiagnosticimagingDTO DTO){

        if(diagnosticimagingRepository.findById(DTO.getId()).isPresent())
            throw new DiagnosticimagingService.DiagnosticimagingDuplicateFound(DTO.getId());

        diagnosticimagingRepository.save(new DiagnosticimagingMapperImpl().diagnosticimagingDTOToDiagnosticimaging(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteDiagnosticimaging(Integer id){

        diagnosticimagingRepository.findById(id).orElseThrow(() -> new DiagnosticimagingService.DiagnosticimagingNotFound(id));
        diagnosticimagingRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateDiagnosticimaging(DiagnosticimagingDTO DTO){

        Diagnosticimaging setEntity = diagnosticimagingRepository.findById(DTO.getId()).orElseThrow(() -> new DiagnosticimagingService.DiagnosticimagingNotFound(DTO.getId()));

        if (DTO.getDateDI() != null)
            setEntity.setDateDI(DTO.getDateDI());

        if (DTO.getTypeDIId() != null)
            typeofdiagnosticimagingRepository.findById(DTO.getTypeDIId()).ifPresent(setEntity::setTypeDI);

        if (DTO.getFinding() != null)
            setEntity.setFinding(DTO.getFinding());

        diagnosticimagingRepository.save(setEntity);

    }
    /* Custom exceptions for this class
     * NotFound
     * DuplicateFound
     */
    static class DiagnosticimagingNotFound extends Exception{
        public DiagnosticimagingNotFound(String errorMessage){
            super(errorMessage);
        }
        public DiagnosticimagingNotFound(){
            super("Diagnosticimaging not found");
        }
        public DiagnosticimagingNotFound(Integer id){
            super("Diagnosticimaging of ID:"+id+" not found");
        }
        public DiagnosticimagingNotFound(Long ULI){
            super("Diagnosticimaging of ULI:"+ULI+" not found");
        }
    }
    static class DiagnosticimagingDuplicateFound extends Exception{
        public DiagnosticimagingDuplicateFound(String errorMessage){
            super(errorMessage);
        }
        public DiagnosticimagingDuplicateFound(){
            super("Diagnosticimaging already exists");
        }
        public DiagnosticimagingDuplicateFound(Integer id){
            super("Diagnosticimaging of ID:"+id+" already exists");
        }
    }

}
