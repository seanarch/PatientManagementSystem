package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.PastmedicalhistoryDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.PastmedicalhistoryMapperImpl;
import com.PatManSystem.main.Models.Pastmedicalhistory;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.PastmedicalhistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PastmedicalhistoryService {

    private final PastmedicalhistoryRepository pastmedicalhistoryRepository;

    @Autowired
    public PastmedicalhistoryService(PastmedicalhistoryRepository pastmedicalhistoryRepository){
        this.pastmedicalhistoryRepository = pastmedicalhistoryRepository;
    }

    public List<PastmedicalhistoryDTO> getPastmedicalhistorys(){
        return pastmedicalhistoryRepository.findAll()
                .stream()
                .map(new PastmedicalhistoryMapperImpl()::pastmedicalhistoryToPastmedicalhistoryDTO)
                .collect(Collectors.toList());
    }

    public PastmedicalhistoryDTO getPastmedicalhistoryById(Integer id) throws NotFoundException{
        Pastmedicalhistory pastmedicalhistory = pastmedicalhistoryRepository.findPastmedicalhistoryById(id);

        if(pastmedicalhistory == null)
            throw new NotFoundException(id);

        return new PastmedicalhistoryMapperImpl().pastmedicalhistoryToPastmedicalhistoryDTO(pastmedicalhistory);
    }

    public List<PastmedicalhistoryDTO> getPastmedicalhistorysByULI(Long ULI) throws NotFoundException{
        List<Pastmedicalhistory> getPastmedicalhistory = pastmedicalhistoryRepository.findPastmedicalhistoryByUli(new Patientinformation(ULI));

        if (getPastmedicalhistory.isEmpty())
            throw new NotFoundException(ULI);

        return getPastmedicalhistory.stream()
                .map(pastmedicalhistory -> new PastmedicalhistoryMapperImpl().pastmedicalhistoryToPastmedicalhistoryDTO(pastmedicalhistory))
                .collect(Collectors.toList());
    }

    public void newPastmedicalhistory(PastmedicalhistoryDTO pastmedicalhistoryDTO) throws DuplicateFoundException{
        if (pastmedicalhistoryDTO.getId() != null && pastmedicalhistoryRepository.findPastmedicalhistoryById(pastmedicalhistoryDTO.getId()) != null)
            throw new DuplicateFoundException(pastmedicalhistoryDTO.getId());

        pastmedicalhistoryRepository.save(new PastmedicalhistoryMapperImpl().pastmedicalhistoryDTOToPastmedicalhistory(pastmedicalhistoryDTO));
    }

    public void deletePastmedicalhistory(Integer id) throws NotFoundException {
        if(pastmedicalhistoryRepository.findPastmedicalhistoryById(id) == null)
            throw new NotFoundException(id);

        pastmedicalhistoryRepository.deleteById(id);
    }

    public void updatePastmedicalhistory(PastmedicalhistoryDTO pastmedicalhistoryDTO) throws NotFoundException {
        Pastmedicalhistory pastmedicalhistory = pastmedicalhistoryRepository.findPastmedicalhistoryById(pastmedicalhistoryDTO.getId());

        if(pastmedicalhistory == null)
            throw new NotFoundException(pastmedicalhistoryDTO.getId());

       if (pastmedicalhistoryDTO.getDx() != null)
           pastmedicalhistory.setDx(pastmedicalhistoryDTO.getDx());

       if(pastmedicalhistoryDTO.getGenDx() != null)
           pastmedicalhistory.setGenDx(pastmedicalhistory.getGenDx());

        pastmedicalhistoryRepository.save(pastmedicalhistory);

    }
}
