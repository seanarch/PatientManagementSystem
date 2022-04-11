package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.RadiationtherapyDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.RadiationtherapyMapperImpl;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Models.Radiationtherapy;
import com.PatManSystem.main.Repository.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RadiationtherapyService {


    private final RadiationtherapyRepository radiationtherapyRepository;
    private final TypeofradiationtherapyRepository typeofradiationtherapyRepository;
    private final BodylocationRepository bodylocationRepository;
    private final ZrtlungRepository zrtlungRepository;
    private final ZrtugiRepository zrtugiRepository;
    private final ZrtskinRepository zrtskinRepository;
    private final ZrtlgiRepository zrtlgiRepository;
    private final ZrtguRepository zrtguRepository;
    private final ZrthemeRepository zrthemeRepository;
    private final ZrthepRepository zrthepRepository;
    private final ZrtplanRepository zrtplanRepository;

    @Autowired
    public RadiationtherapyService(
            RadiationtherapyRepository radiationtherapyRepository,
            TypeofradiationtherapyRepository typeofradiationtherapyRepository,
            BodylocationRepository bodylocationRepository,
            ZrtlungRepository zrtlungRepository,
            ZrtugiRepository zrtugiRepository,
            ZrtskinRepository zrtskinRepository,
            ZrtlgiRepository zrtlgiRepository,
            ZrtguRepository zrtguRepository,
            ZrthemeRepository zrthemeRepository,
            ZrthepRepository zrthepRepository,
            ZrtplanRepository zrtplanRepository){

            this.radiationtherapyRepository =radiationtherapyRepository;
            this.typeofradiationtherapyRepository = typeofradiationtherapyRepository;
            this.bodylocationRepository = bodylocationRepository;
            this.zrtlungRepository = zrtlungRepository;
            this.zrtugiRepository = zrtugiRepository;
            this.zrtskinRepository = zrtskinRepository;
            this.zrtlgiRepository = zrtlgiRepository;
            this.zrtguRepository = zrtguRepository;
            this.zrthemeRepository = zrthemeRepository;
            this.zrthepRepository = zrthepRepository;
            this.zrtplanRepository = zrtplanRepository;
    }

    public List<RadiationtherapyDTO> getRadiationtherapys(){
        return radiationtherapyRepository.findAll()
                .stream()
                .map(new RadiationtherapyMapperImpl()::radiationtherapyToRadiationtherapyDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public RadiationtherapyDTO getRadiationtherapy(Integer id){
        return new RadiationtherapyMapperImpl()
                .radiationtherapyToRadiationtherapyDTO(radiationtherapyRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Radiationtherapy identified by id:{"+id+"} was not found.")));
    }

    @SneakyThrows
    public List<RadiationtherapyDTO> getByULI(Long ULI){

        List<Radiationtherapy> getRadiationtherapys = radiationtherapyRepository.findByUli(new Patientinformation(ULI));

        if(getRadiationtherapys.isEmpty())
            throw new NotFoundException("Radiationtherapy identified by ULI:{"+ULI+"} was not found.");

        return getRadiationtherapys.stream()
                .map(new RadiationtherapyMapperImpl()::radiationtherapyToRadiationtherapyDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public void newRadiationtherapy(RadiationtherapyDTO DTO) {

        if (DTO.getId() != null && radiationtherapyRepository.findById(DTO.getId()).isPresent())
            throw new DuplicateFoundException("Raditationtherapy identified by ID:{" + DTO.getId() + "} already exists.");

        if (DTO.getTypeRTId() == null)
            DTO.setTypeRTId(12); //null default ID 12 (Other)

        if (DTO.getLocationId() == null)
            DTO.setLocationId(92); //null default ID 92 (Unknown)

        if (DTO.getPlanningId() == null)
            DTO.setPlanningId(11); //null default ID 11 (N/A)

        if (DTO.getPneumonitisId() == null)
            DTO.setPneumonitisId(1); //null default ID 1 (No Symptoms)

        if (DTO.getUpperGIId() == null)
            DTO.setUpperGIId(1); //null default ID 1 (No Symptoms)

        if (DTO.getSkinReactionId() == null)
            DTO.setSkinReactionId(1); //null default ID 1 (No Symptoms)

        if (DTO.getLowerGIId() == null)
            DTO.setLowerGIId(1); //null default ID 1 (No Symptoms)

        if (DTO.getGuId() == null)
            DTO.setGuId(1); //null default ID 1 (No Symptoms)

        if (DTO.getHemeId() == null)
            DTO.setHemeId(1); //null default ID 1 (No Symptoms)

        if (DTO.getHepaticId() == null)
            DTO.setHepaticId(1); //null default ID 1 (No Symptoms)

        radiationtherapyRepository.save(new RadiationtherapyMapperImpl().radiationtherapyDTOToRadiationtherapy(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteRadiationtherapy(Integer id){

        radiationtherapyRepository.findById(id).orElseThrow(() -> new NotFoundException("Radiationtherapy identified by ID:{"+id+"} was not found."));
        radiationtherapyRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateRadiationtherapy(RadiationtherapyDTO DTO){

        Radiationtherapy setEntity = radiationtherapyRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Radiationtherapy identified by ID:{"+DTO.getId()+"} was not found."));

        if (DTO.getDateRTStart() != null)
            setEntity.setDateRTStart(DTO.getDateRTStart());

        if (DTO.getDateRTEnd() != null)
            setEntity.setDateRTEnd(DTO.getDateRTEnd());

        if (DTO.getTypeRTId() != null)
            typeofradiationtherapyRepository.findById(DTO.getTypeRTId()).ifPresent(setEntity::setTypeRT);

        if (DTO.getLocationId() != null)
            bodylocationRepository.findById(DTO.getLocationId()).ifPresent(setEntity::setLocation);

        if (DTO.getRTDose() != null)
            setEntity.setRTDose(DTO.getRTDose());

        if (DTO.getFraction() != null)
            setEntity.setFraction(DTO.getFraction());

        if (DTO.getPlanningId() != null)
            zrtplanRepository.findById(DTO.getPlanningId()).ifPresent(setEntity::setPlanning);

        if (DTO.getAnatDetail() != null)
            setEntity.setAnatDetail(DTO.getAnatDetail());

        if (DTO.getGeneral() != null)
            setEntity.setGeneral(DTO.getGeneral());

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

        if (DTO.getOtherToxicity() != null)
            setEntity.setOtherToxicity(DTO.getOtherToxicity());

        if (DTO.getOtherToxicityDetail() != null)
            setEntity.setOtherToxicityDetail(DTO.getOtherToxicityDetail());

        if (DTO.getDetails() != null)
            setEntity.setDetails(DTO.getDetails());

        if (DTO.getNg() != null)
            setEntity.setNg(DTO.getNg());

        radiationtherapyRepository.save(setEntity);

    }
}
