package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.HistoryofpresentillnessDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.HistoryofpresentillnessMapperImpl;
import com.PatManSystem.main.Models.Historyofpresentillness;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.HistoryofpresentillnessRepository;
import com.PatManSystem.main.Repository.TypeofhistoryofpresentillnessRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryofpresentillnessService {


    private final HistoryofpresentillnessRepository historyofpresentillnessRepository;
    private final TypeofhistoryofpresentillnessRepository typeofhistoryofpresentillnessRepository;

    @Autowired
    public HistoryofpresentillnessService( HistoryofpresentillnessRepository historyofpresentillnessRepository,
                                           TypeofhistoryofpresentillnessRepository typeofhistoryofpresentillnessRepository){
        this.historyofpresentillnessRepository = historyofpresentillnessRepository;
        this.typeofhistoryofpresentillnessRepository = typeofhistoryofpresentillnessRepository;
    }

    public List<HistoryofpresentillnessDTO> getHistoryofpresentillnesss(){
        return historyofpresentillnessRepository.findAll()
                .stream()
                .map(new HistoryofpresentillnessMapperImpl()::historyofpresentillnessToHistoryofpresentillnessDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public HistoryofpresentillnessDTO getHistoryofpresentillness(Integer id){
        return new HistoryofpresentillnessMapperImpl(). historyofpresentillnessToHistoryofpresentillnessDTO( historyofpresentillnessRepository.findById(id).orElseThrow(() -> new NotFoundException("Historyofpresentillness identified by ID:{"+id+"} was not found.")));
    }

    @SneakyThrows
    public List<HistoryofpresentillnessDTO> getByULI(Long ULI){

        List<Historyofpresentillness> getHistoryofpresentillnesss =  historyofpresentillnessRepository.findByUli(new Patientinformation(ULI));

        if(getHistoryofpresentillnesss.isEmpty())
            throw new NotFoundException("Historyofpresentillness identified by ID:{"+ULI+"} was not found.");

        return getHistoryofpresentillnesss.stream()
                .map(new HistoryofpresentillnessMapperImpl():: historyofpresentillnessToHistoryofpresentillnessDTO)
                .collect(Collectors.toList());

    }

    @SneakyThrows
    public void newHistoryofpresentillness(HistoryofpresentillnessDTO DTO){

        if(DTO.getId() != null && historyofpresentillnessRepository.existsById(DTO.getId()))
            throw new DuplicateFoundException(DTO.getId());

        if(DTO.getDescriptorId() == null)
            DTO.setDescriptorId(4); //if null set to default ID 4 (otherwise healthy)

         historyofpresentillnessRepository.save(new HistoryofpresentillnessMapperImpl(). historyofpresentillnessDTOToHistoryofpresentillness(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteHistoryofpresentillness(Integer id){

         historyofpresentillnessRepository.findById(id).orElseThrow(() -> new NotFoundException("Historyofpresentillness identified by ID:{"+id+"} was not found."));
         historyofpresentillnessRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateHistoryofpresentillness(HistoryofpresentillnessDTO DTO){

        Historyofpresentillness setEntity =  historyofpresentillnessRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Historyofpresentillness identified by ID:{"+DTO.getId()+"} was not found."));

        if (DTO.getDescriptorId() != null)
            typeofhistoryofpresentillnessRepository.findById(DTO.getDescriptorId()).ifPresent(setEntity::setDescriptor);

         historyofpresentillnessRepository.save(setEntity);

    }
}
