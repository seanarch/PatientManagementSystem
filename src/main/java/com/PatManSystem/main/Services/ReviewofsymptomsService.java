package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ReviewofsymptomsDTO;
import com.PatManSystem.main.Exception.DuplicateFoundException;
import com.PatManSystem.main.Exception.NotFoundException;
import com.PatManSystem.main.Mapper.ReviewofsymptomsMapperImpl;
import com.PatManSystem.main.Models.Patientinformation;
import com.PatManSystem.main.Models.Reviewofsymptoms;
import com.PatManSystem.main.Repository.ReviewofsymptomsRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewofsymptomsService {


    private final ReviewofsymptomsRepository reviewofsymptomsRepository;

    @Autowired
    public ReviewofsymptomsService(ReviewofsymptomsRepository reviewofsymptomsRepository){
        this.reviewofsymptomsRepository = reviewofsymptomsRepository;
    }

    public List<ReviewofsymptomsDTO> getReviewofsymptomss(){
        return reviewofsymptomsRepository.findAll()
                .stream()
                .map(new ReviewofsymptomsMapperImpl()::reviewofsymptomsToReviewofsymptomsDTO)
                .collect(Collectors.toList());
    }
    @SneakyThrows
    public ReviewofsymptomsDTO getReviewofsymptoms(Integer id){
        return new ReviewofsymptomsMapperImpl().reviewofsymptomsToReviewofsymptomsDTO(reviewofsymptomsRepository.findById(id).orElseThrow(() -> new NotFoundException("Reviewofsymptoms identified by ID:{" + id + "} was not found")));
    }

    @SneakyThrows
    public List<ReviewofsymptomsDTO> getByULI(Long ULI){

        List<Reviewofsymptoms> getReviewofsymptomss = reviewofsymptomsRepository.findByUli(new Patientinformation(ULI));

        if(getReviewofsymptomss.isEmpty())
            throw new NotFoundException("Reviewofsymptoms identified by ID:{" + ULI + "} was not found");

        return getReviewofsymptomss.stream()
                .map(new ReviewofsymptomsMapperImpl()::reviewofsymptomsToReviewofsymptomsDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public void newReviewofsymptoms(ReviewofsymptomsDTO DTO) {

        if (DTO.getId() != null && reviewofsymptomsRepository.findById(DTO.getId()).isPresent())
            throw new DuplicateFoundException("Reviewofsymptoms identified by ID:{" + DTO.getId() + "} already exists.");

        reviewofsymptomsRepository.save(new ReviewofsymptomsMapperImpl().reviewofsymptomsDTOToReviewofsymptoms(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteReviewofsymptoms(Integer id){

        reviewofsymptomsRepository.findById(id).orElseThrow(() -> new NotFoundException("Reviewofsymptoms identified by ID:{" + id + "} was not found"));
        reviewofsymptomsRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateReviewofsymptoms(ReviewofsymptomsDTO DTO){

        Reviewofsymptoms setEntity = reviewofsymptomsRepository.findById(DTO.getId()).orElseThrow(() -> new NotFoundException("Reviewofsymptoms identified by ID:{" + DTO.getId() + "} was not found"));

        for (Method getter : DTO.getClass().getMethods()) {
            Object get = "";
            if (getter.getName().startsWith("get") && getter.getParameterTypes().length == 0) {
                try {
                    get = getter.invoke(DTO);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (get != null)
                    for (Method setter : setEntity.getClass().getMethods()) {
                        if (setter.getName().startsWith("set") && setter.getName().endsWith(getter.getName().substring(3)) && setter.getParameterTypes().length == 1) {
                            try {
                                setter.invoke(setEntity, get);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                            continue;
                        }
                    }
            }
        }
        reviewofsymptomsRepository.save(setEntity);

    }
}
