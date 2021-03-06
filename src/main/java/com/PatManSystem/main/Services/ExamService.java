package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ExamDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.ExamMapperImpl;
import com.PatManSystem.main.Models.Exam;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamService {

    private final ExamRepository examRepository;
    private final AbdomenRepository abdomenRepository;
    private final CentralnervoussystemRepository centralnervoussystemRepository;
    private final LungRepository lungRepository;
    private final HeadandneckRepository headandneckRepository;
    private final OralRepository oralRepository;
    private final CardiacRepository cardiacRepository;
    private final MusculoskeletalRepository musculoskeletalRepository;
    private final SkinRepository skinRepository;
    private final SupineRepository supineRepository;
    private final BreathRepository breathRepository;

    @Autowired
    public ExamService(ExamRepository examRepository,
                       AbdomenRepository abdomenRepository,
                       CentralnervoussystemRepository centralnervoussystemRepository,
                       LungRepository lungRepository,
                       HeadandneckRepository headandneckRepository,
                       OralRepository oralRepository,
                       CardiacRepository cardiacRepository,
                       MusculoskeletalRepository musculoskeletalRepository,
                       SkinRepository skinRepository,
                       SupineRepository supineRepository,
                       BreathRepository breathRepository){

        this.examRepository = examRepository;
        this.abdomenRepository = abdomenRepository;
        this.centralnervoussystemRepository = centralnervoussystemRepository;
        this.lungRepository = lungRepository;
        this.headandneckRepository = headandneckRepository;
        this.oralRepository = oralRepository;
        this.cardiacRepository = cardiacRepository;
        this.musculoskeletalRepository = musculoskeletalRepository;
        this.skinRepository = skinRepository;
        this.supineRepository = supineRepository;
        this.breathRepository = breathRepository;

    }

    public List<ExamDTO> getExams(){
       return examRepository.findAll()
               .stream()
               .map(exam -> new ExamMapperImpl().examToExamDTO(exam))
               .collect(Collectors.toList());
    }
    @SneakyThrows
    public ExamDTO getExam(Long id){
        Optional<Exam> getExam = examRepository.findById(id);
        if(getExam.isEmpty()) //check if the requested patient exists, if not; throw not found exception
            throw new NotFoundException("Exam identified by ID:{"+id+ "} does not exist.");

        return new ExamMapperImpl().examToExamDTO(getExam.get());
    }
    @SneakyThrows
    public List<ExamDTO> getExamByULI(Long ULI){

        List<Exam> getExams = examRepository.findByUli(new Patientinformation(ULI));
        if(getExams == null) //check if the requested patient exists, if not; throw not found exception
            throw new NotFoundException("Exam identified by ULI:{"+ULI+"} does not exist.");

        return getExams.stream()
                .map(exam -> new ExamMapperImpl().examToExamDTO(exam))
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public void newExam(ExamDTO examDTO){

        if(examDTO.getId() != null && examRepository.findById(examDTO.getId()).isPresent())  //check if the requested patient exists, if not; throw not found exception
            throw new DuplicateFoundException("Exam identified by ID:{"+examDTO.getId()+"} already exists.");
        else {
            examRepository.save(new ExamMapperImpl().examDTOToExam(examDTO)); // convert incoming DTO to DB entity and save to the DB
        }

    }
    @SneakyThrows
    public void deleteExam(Long id){

        if(examRepository.findById(id).isEmpty()){ //check if the requested patient exists, if not; throw not found exception
            throw new NotFoundException("Exam identified by ID:{"+id+ "} does not exist.");
        }else{
            examRepository.deleteById(id);
        }
    }
    @SneakyThrows
    public void updateExam(ExamDTO DTO){
        Optional<Exam> getEntity = examRepository.findById(DTO.getId()); //retrieve a copy of the entity

        /*
            IF the repository can find the object specified by the id
            THEN set respective object in setEntity to the object returned by the repository
            FINALLY save the setEntity object, JPA opens a transaction and performs the update.
            ELSE throw an exception
        */

        if(getEntity.isPresent()){
            Exam setEntity = getEntity.get();

            if (DTO.getAbdoId() != null)
                abdomenRepository.findById(DTO.getAbdoId()).ifPresent(setEntity::setAbdo);

            if (DTO.getDate() != null)
               setEntity.setDate(DTO.getDate());

            if (DTO.getCnsId() != null)
                centralnervoussystemRepository.findById(DTO.getCnsId()).ifPresent(setEntity::setCns);

            if (DTO.getLungId() != null)
                lungRepository.findById(DTO.getLungId()).ifPresent(setEntity::setLung);

            if (DTO.getHnId() != null)
                headandneckRepository.findById(DTO.getHnId()).ifPresent(setEntity::setHn);

            if (DTO.getOralId() != null)
                oralRepository.findById(DTO.getOralId()).ifPresent(setEntity::setOral);

            if (DTO.getCardiacId() != null)
                cardiacRepository.findById(DTO.getCardiacId()).ifPresent(setEntity::setCardiac);

            if (DTO.getMskId() != null)
                musculoskeletalRepository.findById(DTO.getMskId()).ifPresent(setEntity::setMsk);

            if (DTO.getPeripheralId() != null)
                skinRepository.findById(DTO.getPeripheralId()).ifPresent(setEntity::setPeripheral);

            if (DTO.getSupineId() != null)
                supineRepository.findById(DTO.getSupineId()).ifPresent(setEntity::setSupine);

            if (DTO.getAbnormal() != null)
                setEntity.setAbnormal(DTO.getAbnormal());

            if (DTO.getBreathId() != null)
                breathRepository.findById(DTO.getBreathId()).ifPresent(setEntity::setBreath);


            examRepository.save(setEntity);

        }else {
            throw new NotFoundException("Exam identified by ID:{"+DTO.getId()+ "} does not exist.");
        }


    }
}
