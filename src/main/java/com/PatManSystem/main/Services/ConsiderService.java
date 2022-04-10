package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ConsiderDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.ConsiderMapperImpl;
import com.PatManSystem.main.Models.Consider;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.ConsiderRepository;
import com.PatManSystem.main.Repository.TypeofconsiderationRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsiderService {

    private final ConsiderRepository considerRepository;
    private final TypeofconsiderationRepository typeofconsiderationRepository;

    @Autowired
    public ConsiderService(ConsiderRepository considerRepository,
                           TypeofconsiderationRepository typeofconsiderationRepository){
        this.considerRepository = considerRepository;
        this.typeofconsiderationRepository = typeofconsiderationRepository;

    }

    public List<ConsiderDTO> getConsiders(){
        return considerRepository.findAll()
                .stream()
                .map(new ConsiderMapperImpl()::considerToConsiderDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public ConsiderDTO getConsider(Integer id){
        return new ConsiderMapperImpl().considerToConsiderDTO(considerRepository.findById(id).orElseThrow(() -> new NotFoundException("Consider identified by ID:{"+id+"} was not found.")));
    }

    @SneakyThrows
    public List<ConsiderDTO> getByULI(Long ULI){

        List<Consider> getConsiders = considerRepository.findByUli(new Patientinformation(ULI));

        if(getConsiders.isEmpty())
            throw new NotFoundException("Consider identified by ULI:{"+ULI+"} was not found.");

        return getConsiders.stream()
                .map(new ConsiderMapperImpl()::considerToConsiderDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public void newConsider(ConsiderDTO DTO){

        if(DTO.getId() != null && considerRepository.findById(DTO.getId()).isPresent())
            throw new DuplicateFoundException("Consider identified by ID:{"+DTO.getId()+"} already exists.");

        considerRepository.save(new ConsiderMapperImpl().considerDTOToConsider(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteConsider(Integer id){

        considerRepository.findById(id).orElseThrow(() -> new NotFoundException("Consider identified by ID:{"+id+"} was not found."));
        considerRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateConsider(ConsiderDTO DTO){

        Consider setEntity = considerRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Consider identified by ID:{"+DTO.getId()+"} was not found."));

        if (DTO.getConsiderId() != null)
            typeofconsiderationRepository.findById(DTO.getConsiderId()).ifPresent(setEntity::setConsider);

        if (DTO.getDetail() != null)
            setEntity.setDetail(DTO.getDetail());

        considerRepository.save(setEntity);

    }

}