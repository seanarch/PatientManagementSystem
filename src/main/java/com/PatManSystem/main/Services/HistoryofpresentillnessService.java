package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.HistoryofpresentillnessDTO;
import com.PatManSystem.main.DTO.HistoryofpresentillnessDTO;
import com.PatManSystem.main.Mapper.HistoryofpresentillnessMapperImpl;
import com.PatManSystem.main.Mapper.HistoryofpresentillnessMapperImpl;
import com.PatManSystem.main.Models.Historyofpresentillness;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Models.Typeofhistoryofpresentillness;
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
        return new HistoryofpresentillnessMapperImpl(). historyofpresentillnessToHistoryofpresentillnessDTO( historyofpresentillnessRepository.findById(id).orElseThrow(() -> new HistoryofpresentillnessService.HistoryofpresentillnessNotFound(id)));
    }

    @SneakyThrows
    public List<HistoryofpresentillnessDTO> getByULI(Long ULI){

        List<Historyofpresentillness> getHistoryofpresentillnesss =  historyofpresentillnessRepository.findByUli(new Patientinformation(ULI));

        if(getHistoryofpresentillnesss.isEmpty())
            throw new HistoryofpresentillnessService.HistoryofpresentillnessNotFound(ULI);

        return getHistoryofpresentillnesss.stream()
                .map(new HistoryofpresentillnessMapperImpl():: historyofpresentillnessToHistoryofpresentillnessDTO)
                .collect(Collectors.toList());

    }

    @SneakyThrows
    public void newHistoryofpresentillness(HistoryofpresentillnessDTO DTO){

        if( historyofpresentillnessRepository.findById(DTO.getId()).isPresent())
            throw new HistoryofpresentillnessService.HistoryofpresentillnessDuplicateFound(DTO.getId());

         historyofpresentillnessRepository.save(new HistoryofpresentillnessMapperImpl(). historyofpresentillnessDTOToHistoryofpresentillness(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteHistoryofpresentillness(Integer id){

         historyofpresentillnessRepository.findById(id).orElseThrow(() -> new HistoryofpresentillnessService.HistoryofpresentillnessNotFound(id));
         historyofpresentillnessRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateHistoryofpresentillness(HistoryofpresentillnessDTO DTO){

        Historyofpresentillness setEntity =  historyofpresentillnessRepository.findById(DTO.getId()).orElseThrow(() -> new HistoryofpresentillnessService.HistoryofpresentillnessNotFound(DTO.getId()));

        if (DTO.getDescriptorId() != null)
            typeofhistoryofpresentillnessRepository.findById(DTO.getDescriptorId()).ifPresent(setEntity::setDescriptor);

         historyofpresentillnessRepository.save(setEntity);

    }
    /* Custom exceptions for this class
     * NotFound
     * DuplicateFound
     */
    static class HistoryofpresentillnessNotFound extends Exception{
        public HistoryofpresentillnessNotFound(String errorMessage){
            super(errorMessage);
        }
        public HistoryofpresentillnessNotFound(){
            super("Historyofpresentillness not found");
        }
        public HistoryofpresentillnessNotFound(Integer id){
            super("Historyofpresentillness of ID:"+id+" not found");
        }
        public HistoryofpresentillnessNotFound(Long ULI){
            super("Historyofpresentillness of ULI:"+ULI+" not found");
        }
    }
    static class HistoryofpresentillnessDuplicateFound extends Exception{
        public HistoryofpresentillnessDuplicateFound(String errorMessage){
            super(errorMessage);
        }
        public HistoryofpresentillnessDuplicateFound(){
            super("Historyofpresentillness already exists");
        }
        public HistoryofpresentillnessDuplicateFound(Integer id){
            super("Historyofpresentillness of ID:"+id+" already exists");
        }
    }

}
