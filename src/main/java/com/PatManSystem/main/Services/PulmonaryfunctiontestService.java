package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.PulmonaryfunctiontestDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.PulmonaryfunctiontestMapperImpl;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Models.Pulmonaryfunctiontest;
import com.PatManSystem.main.Repository.PulmonaryfunctiontestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PulmonaryfunctiontestService {

    private PulmonaryfunctiontestRepository pulmonaryfunctiontestRepository;

    @Autowired
    public PulmonaryfunctiontestService(PulmonaryfunctiontestRepository pulmonaryfunctiontestRepository){
        this.pulmonaryfunctiontestRepository = pulmonaryfunctiontestRepository;
    }

    public List<PulmonaryfunctiontestDTO> getPulmonaryfunctiontests(){
        return pulmonaryfunctiontestRepository.findAll()
                .stream()
                .map(pulmonaryfunctiontest -> {
                    return new PulmonaryfunctiontestMapperImpl().pulmonaryfunctiontestToPulmonaryfunctiontestDTO(pulmonaryfunctiontest);
                })
                .collect(Collectors.toList());
    }

    public PulmonaryfunctiontestDTO getPulmonaryfunctiontestById(Integer id) throws NotFoundException {
        Pulmonaryfunctiontest pulmonaryfunctiontest = pulmonaryfunctiontestRepository.findPulmonaryfunctiontestById(id);

        if(pulmonaryfunctiontest == null)
            throw new NotFoundException(id);

        return new PulmonaryfunctiontestMapperImpl().pulmonaryfunctiontestToPulmonaryfunctiontestDTO(pulmonaryfunctiontest);
    }

    public List<PulmonaryfunctiontestDTO> getPulmonaryfunctiontestByULI(Long ULI) throws NotFoundException{
        List<Pulmonaryfunctiontest> pulmonaryfunctiontests = pulmonaryfunctiontestRepository.findPulmonaryfunctiontestByUli(new Patientinformation(ULI));

        if(pulmonaryfunctiontests.isEmpty())
            throw new NotFoundException(ULI);

        return pulmonaryfunctiontests.stream()
                .map(pulmonaryfunctiontest -> new PulmonaryfunctiontestMapperImpl().pulmonaryfunctiontestToPulmonaryfunctiontestDTO(pulmonaryfunctiontest))
                .collect(Collectors.toList());
    }

    public void newPulmonaryfunctiontest(PulmonaryfunctiontestDTO pulmonaryfunctiontestDTO) throws DuplicateFoundException {
        if(pulmonaryfunctiontestRepository.findPulmonaryfunctiontestById(pulmonaryfunctiontestDTO.getId()) != null)
            throw new DuplicateFoundException(pulmonaryfunctiontestDTO.getId());

        pulmonaryfunctiontestRepository.save(new PulmonaryfunctiontestMapperImpl().pulmonaryfunctiontestDTOToPulmonaryfunctiontest(pulmonaryfunctiontestDTO));
    }

    public void deletePulmonaryfunctiontest(Integer id) throws NotFoundException{
        if(pulmonaryfunctiontestRepository.findPulmonaryfunctiontestById(id) == null)
            throw new NotFoundException(id);

        pulmonaryfunctiontestRepository.deleteById(id);
    }

    public void updatePulmonaryfunctiontest(PulmonaryfunctiontestDTO pulmonaryfunctiontestDTO) throws NotFoundException{
        Pulmonaryfunctiontest pulmonaryfunctiontest = pulmonaryfunctiontestRepository.findPulmonaryfunctiontestById(pulmonaryfunctiontestDTO.getId());

        if(pulmonaryfunctiontest == null)
            throw new NotFoundException(pulmonaryfunctiontestDTO.getId());

        new PulmonaryfunctiontestMapperImpl().updatePulmonaryfunctiontestFromPulmonaryfunctiontestDTO(pulmonaryfunctiontestDTO, pulmonaryfunctiontest);

        pulmonaryfunctiontestRepository.save(pulmonaryfunctiontest);
    }
}
