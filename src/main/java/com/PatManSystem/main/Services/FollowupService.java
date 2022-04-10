package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.FollowupDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.FollowupMapperImpl;
import com.PatManSystem.main.Models.Followup;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Repository.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowupService {

    
    private final FollowupRepository followupRepository;
    private final ZfuRepository zfuRepository;
    private final ZrtresponseRepository zrtresponseRepository;
    private final ZrtlungRepository zrtlungRepository;
    private final ZrtugiRepository zrtugiRepository;
    private final ZrtskinRepository zrtskinRepository;
    private final ZrtlgiRepository zrtlgiRepository;
    private final ZrtguRepository zrtguRepository;
    private final ZrthemeRepository zrthemeRepository;
    private final ZrthepRepository zrthepRepository;    
    
    @Autowired
    public FollowupService(
            FollowupRepository followupRepository,
            ZfuRepository zfuRepository,
            ZrtresponseRepository zrtresponseRepository,
            ZrtlungRepository zrtlungRepository,
            ZrtugiRepository zrtugiRepository,
            ZrtskinRepository zrtskinRepository,
            ZrtlgiRepository zrtlgiRepository,
            ZrtguRepository zrtguRepository,
            ZrthemeRepository zrthemeRepository,
            ZrthepRepository zrthepRepository){

        this.followupRepository = followupRepository;
        this.zfuRepository = zfuRepository;
        this.zrtresponseRepository =  zrtresponseRepository;
        this.zrtlungRepository = zrtlungRepository;
        this.zrtugiRepository = zrtugiRepository;
        this.zrtskinRepository = zrtskinRepository;
        this.zrtlgiRepository = zrtlgiRepository;
        this.zrtguRepository = zrtguRepository;
        this.zrthemeRepository = zrthemeRepository;
        this.zrthepRepository = zrthepRepository;
    }
    
    public List<FollowupDTO> getFollowups(){
        return followupRepository.findAll()
                .stream()
                .map(new FollowupMapperImpl()::followupToFollowupDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public FollowupDTO getFollowup(Integer id){
        return new FollowupMapperImpl().followupToFollowupDTO(followupRepository.findById(id).orElseThrow(() ->  new NotFoundException("Followup identified by ID:{"+id+"} was not found.")));
    }

    @SneakyThrows
    public List<FollowupDTO> getByULI(Long ULI){

        List<Followup> getFollowups = followupRepository.findByUli(new Patientinformation(ULI));

        if(getFollowups.isEmpty())
            throw new NotFoundException("Followup identified by ID:{"+ULI+"} was not found.");

        return getFollowups.stream()
                .map(new FollowupMapperImpl()::followupToFollowupDTO)
                .collect(Collectors.toList());

    }

    @SneakyThrows
    public void newFollowup(FollowupDTO DTO){

        if(DTO.getId() != null && followupRepository.findById(DTO.getId()).isPresent())
            throw new DuplicateFoundException("Followup identified by ID:{"+DTO.getId()+"} already exists.");

        if(DTO.getClinicalResponseId() == null)
            DTO.setClinicalResponseId(4); //if null set to ID 4 (NA)

        if(DTO.getGuId() == null)
            DTO.setGuId(1); //if null set to ID 1

        if(DTO.getHemeId() == null)
            DTO.setHemeId(1); //if null set to ID 1 (No symptoms)

        if(DTO.getHepaticId() == null)
            DTO.setHepaticId(1); //if null set to ID 1 (No symptoms)

        if(DTO.getLowerGIId() == null)
            DTO.setLowerGIId(1); //if null set to ID 1 (No symptoms)

        if(DTO.getUpperGIId() == null)
            DTO.setUpperGIId(1); //if null set to ID 1 (No symptoms)

        if(DTO.getSkinReactionId() == null)
            DTO.setSkinReactionId(1); //if null set to ID 1 (No symptoms)

        if(DTO.getPneumonitisId() == null)
            DTO.setPneumonitisId(1); //if null set to ID 1 (No symptoms)

        if(DTO.getTypeFUId() == null)
            DTO.setTypeFUId(1); //if null set to ID 1 (first visit)



        followupRepository.save(new FollowupMapperImpl().followupDTOToFollowup(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteFollowup(Integer id){

        followupRepository.findById(id).orElseThrow(() -> new NotFoundException("Followup identified by ID:{"+id+"} was not found."));
        followupRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateFollowup(FollowupDTO DTO){

        Followup setEntity = followupRepository.findById(DTO.getId()).orElseThrow(() ->  new NotFoundException("Followup identified by ID:{"+DTO.getId()+"} was not found."));

        if (DTO.getDate() != null)
            setEntity.setDate(DTO.getDate());

        if (DTO.getClinicalResponseId() != null)
            zrtresponseRepository.findById(DTO.getClinicalResponseId()).ifPresent(setEntity::setClinicalResponse);

        if (DTO.getPneumonitisId() != null)
            zrtlungRepository.findById(DTO.getPneumonitisId()).ifPresent(setEntity::setPneumonitis);

        if (DTO.getUpperGIId() != null)
            zrtugiRepository.findById(DTO.getUpperGIId()).ifPresent(setEntity::setUpperGI);

        if (DTO.getSkinReactionId() != null)
            zrtskinRepository.findById(DTO.getSkinReactionId()).ifPresent(setEntity::setSkinReaction);

        if (DTO.getLowerGIId() != null)
            zrtlgiRepository.findById(DTO.getLowerGIId()).ifPresent(setEntity::setLowerGI);

        if (DTO.getGuId() != null)
            zrtguRepository.findById(DTO.getGuId()).ifPresent(setEntity::setGu);

        if (DTO.getHemeId() != null)
            zrthemeRepository.findById(DTO.getHemeId()).ifPresent(setEntity::setHeme);

        if (DTO.getHepaticId() != null)
            zrthepRepository.findById(DTO.getHepaticId()).ifPresent(setEntity::setHepatic);

        if (DTO.getTypeFUId() != null)
            zfuRepository.findById(DTO.getTypeFUId()).ifPresent(setEntity::setTypeFU);

        if (DTO.getOtherToxicity() != null)
            setEntity.setOtherToxicity(DTO.getOtherToxicity());

        if (DTO.getOtherToxDetail() != null)
            setEntity.setOtherToxDetail(DTO.getOtherToxDetail());

        followupRepository.save(setEntity);

    }
}
