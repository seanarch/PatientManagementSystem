package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.FollowupDTO;
import com.PatManSystem.main.DTO.FollowupDTO;
import com.PatManSystem.main.Mapper.FollowupMapperImpl;
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
        return new FollowupMapperImpl().followupToFollowupDTO(followupRepository.findById(id).orElseThrow(() -> new FollowupService.FollowupNotFound(id)));
    }

    @SneakyThrows
    public List<FollowupDTO> getByULI(Long ULI){

        List<Followup> getFollowups = followupRepository.findByUli(new Patientinformation(ULI));

        if(getFollowups.isEmpty())
            throw new FollowupService.FollowupNotFound(ULI);

        return getFollowups.stream()
                .map(new FollowupMapperImpl()::followupToFollowupDTO)
                .collect(Collectors.toList());

    }

    @SneakyThrows
    public void newFollowup(FollowupDTO DTO){

        if(followupRepository.findById(DTO.getId()).isPresent())
            throw new FollowupService.FollowupDuplicateFound(DTO.getId());

        followupRepository.save(new FollowupMapperImpl().followupDTOToFollowup(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteFollowup(Integer id){

        followupRepository.findById(id).orElseThrow(() -> new FollowupService.FollowupNotFound(id));
        followupRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateFollowup(FollowupDTO DTO){

        Followup setEntity = followupRepository.findById(DTO.getId()).orElseThrow(() -> new FollowupService.FollowupNotFound(DTO.getId()));

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
    /* Custom exceptions for this class
     * NotFound
     * DuplicateFound
     */
    static class FollowupNotFound extends Exception{
        public FollowupNotFound(String errorMessage){
            super(errorMessage);
        }
        public FollowupNotFound(){
            super("Followup not found");
        }
        public FollowupNotFound(Integer id){
            super("Followup of ID:"+id+" not found");
        }
        public FollowupNotFound(Long ULI){
            super("Followup of ULI:"+ULI+" not found");
        }
    }
    static class FollowupDuplicateFound extends Exception{
        public FollowupDuplicateFound(String errorMessage){
            super(errorMessage);
        }
        public FollowupDuplicateFound(){
            super("Followup already exists");
        }
        public FollowupDuplicateFound(Integer id){
            super("Followup of ID:"+id+" already exists");
        }
    }
}
