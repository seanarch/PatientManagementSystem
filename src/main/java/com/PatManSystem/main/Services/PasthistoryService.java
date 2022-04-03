package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.PasthistoryDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.PasthistoryMapperImpl;
import com.PatManSystem.main.Models.Pasthistory;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.GoalofcareRepository;
import com.PatManSystem.main.Repository.PasthistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasthistoryService {

    private PasthistoryRepository pasthistoryRepository;
    private GoalofcareRepository goalofcareRepository;

    @Autowired
    public PasthistoryService(PasthistoryRepository pasthistoryRepository, GoalofcareRepository goalofcareRepository){
        this.pasthistoryRepository = pasthistoryRepository;
        this.goalofcareRepository = goalofcareRepository;
    }

    public List<PasthistoryDTO> getPasthistorys(){
        return pasthistoryRepository.findAll()
                .stream()
                .map(pasthistory -> {
                    return new PasthistoryMapperImpl().pasthistoryToPasthistoryDTO(pasthistory);
                })
                .collect(Collectors.toList());
    }

    //find Pasthistory entity by id and return PasthistoryDTO
    public PasthistoryDTO getPasthistory(Integer id) throws NotFoundException {
        Pasthistory getPasthistory = pasthistoryRepository.findPasthistoryById(id);
        if(getPasthistory == null)
            throw new NotFoundException(id);

        return new PasthistoryMapperImpl().pasthistoryToPasthistoryDTO(getPasthistory);
    }

    //find Pasthistory entity by ULI and return PasthistoryDTO list
    public List<PasthistoryDTO> getPasthistoryByULI(Long ULI) throws NotFoundException {
        List<Pasthistory> getPasthistorys = pasthistoryRepository.findPasthistoryByUli(new Patientinformation(ULI));
        if (getPasthistorys.isEmpty())
            throw new NotFoundException(ULI);

        return getPasthistorys.stream()
                .map(pasthistory -> new PasthistoryMapperImpl().pasthistoryToPasthistoryDTO(pasthistory))
                .collect(Collectors.toList());
    }

    //create new Pasthistory entity by passing PasthistoryDTO
    public void newPasthistory(PasthistoryDTO pasthistoryDTO) throws DuplicateFoundException {
        if(pasthistoryRepository.findPasthistoryById(pasthistoryDTO.getId()) != null){
            throw new DuplicateFoundException(pasthistoryDTO.getId());
        }
        pasthistoryRepository.save(new PasthistoryMapperImpl().pasthistoryDTOToPasthistory(pasthistoryDTO));
    }

    //delete Pasthistory entity by id
    public void deletePasthistory(Integer id) throws NotFoundException {
        if(pasthistoryRepository.findPasthistoryById(id) == null){
            throw new NotFoundException(id);
        }else{
            pasthistoryRepository.deleteById(id);
        }
    }

    //update Pasthistory entity
    public void updatePasthistory(PasthistoryDTO pasthistoryDTO) throws NotFoundException {
        Pasthistory existingPasthistory = pasthistoryRepository.findPasthistoryById(pasthistoryDTO.getId());

        if(existingPasthistory == null)
            throw new NotFoundException(pasthistoryDTO.getId());
        else{

            if ( pasthistoryDTO.getFhxDetail() != null ) {
                existingPasthistory.setFhxDetail( pasthistoryDTO.getFhxDetail());
            }
            if ( pasthistoryDTO.getSmokingPackYears() != null ) {
                existingPasthistory.setSmokingPackYears( pasthistoryDTO.getSmokingPackYears());
            }
            if ( pasthistoryDTO.getSmokeQuit() != null ) {
                existingPasthistory.setSmokeQuit( pasthistoryDTO.getSmokeQuit());
            }
            if ( pasthistoryDTO.getAttendedFamily() != null ) {
                existingPasthistory.setAttendedFamily( pasthistoryDTO.getAttendedFamily());
            }
            if ( pasthistoryDTO.getLacksSocialSupport() != null ) {
                existingPasthistory.setLacksSocialSupport( pasthistoryDTO.getLacksSocialSupport());
            }
            if ( pasthistoryDTO.getLanguageBarrier() != null ) {
                existingPasthistory.setLanguageBarrier( pasthistoryDTO.getLanguageBarrier());
            }
            if ( pasthistoryDTO.getFinancialChallenge() != null ) {
                existingPasthistory.setFinancialChallenge( pasthistoryDTO.getFinancialChallenge());
            }
            if ( pasthistoryDTO.getPsychosocialChallenge() != null ) {
                existingPasthistory.setPsychosocialChallenge( pasthistoryDTO.getPsychosocialChallenge());
            }
            if ( pasthistoryDTO.getGoalofcareId() != null ) {
                goalofcareRepository.findById(pasthistoryDTO.getGoalofcareId()).ifPresent(existingPasthistory::setGoalofcare);
            }
            if ( pasthistoryDTO.getETOHWeek() != null ) {
                existingPasthistory.setETOHWeek(pasthistoryDTO.getETOHWeek());
            }
            if ( pasthistoryDTO.getDetail() != null ) {
                existingPasthistory.setDetail( pasthistoryDTO.getDetail());
            }
            pasthistoryRepository.save(existingPasthistory);
        }
    }


}
