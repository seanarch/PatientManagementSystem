package com.PatManSystem.main.Services;

import com.PatManSystem.main.DTO.ReviewofsymptomsDTO;
import com.PatManSystem.main.Mapper.ReviewofsymptomsMapperImpl;
import com.PatManSystem.main.Models.Reviewofsymptoms;
import com.PatManSystem.main.Models.Patientinformation;
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
        return new ReviewofsymptomsMapperImpl().reviewofsymptomsToReviewofsymptomsDTO(reviewofsymptomsRepository.findById(id).orElseThrow(() -> new ReviewofsymptomsService.ReviewofsymptomsNotFound(id)));
    }

    @SneakyThrows
    public List<ReviewofsymptomsDTO> getByULI(Long ULI){

        List<Reviewofsymptoms> getReviewofsymptomss = reviewofsymptomsRepository.findByUli(new Patientinformation(ULI));

        if(getReviewofsymptomss.isEmpty())
            throw new ReviewofsymptomsService.ReviewofsymptomsNotFound(ULI);

        return getReviewofsymptomss.stream()
                .map(new ReviewofsymptomsMapperImpl()::reviewofsymptomsToReviewofsymptomsDTO)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public void newReviewofsymptoms(ReviewofsymptomsDTO DTO){

        if(reviewofsymptomsRepository.findById(DTO.getId()).isPresent())
            throw new ReviewofsymptomsService.ReviewofsymptomsDuplicateFound(DTO.getId());

        reviewofsymptomsRepository.save(new ReviewofsymptomsMapperImpl().reviewofsymptomsDTOToReviewofsymptoms(DTO)); // convert incoming DTO to DB entity and save to the DB

    }

    @SneakyThrows
    public void deleteReviewofsymptoms(Integer id){

        reviewofsymptomsRepository.findById(id).orElseThrow(() -> new ReviewofsymptomsService.ReviewofsymptomsNotFound(id));
        reviewofsymptomsRepository.deleteById(id);

    }

    @SneakyThrows
    public void updateReviewofsymptoms(ReviewofsymptomsDTO DTO){

        Reviewofsymptoms setEntity = reviewofsymptomsRepository.findById(DTO.getId()).orElseThrow(() -> new ReviewofsymptomsService.ReviewofsymptomsNotFound(DTO.getId()));

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
    /* Custom exceptions for this class
     * NotFound
     * DuplicateFound
     */
    static class ReviewofsymptomsNotFound extends Exception{
        public ReviewofsymptomsNotFound(String errorMessage){
            super(errorMessage);
        }
        public ReviewofsymptomsNotFound(){
            super("Reviewofsymptoms not found");
        }
        public ReviewofsymptomsNotFound(Integer id){
            super("Reviewofsymptoms of ID:"+id+" not found");
        }
        public ReviewofsymptomsNotFound(Long ULI){
            super("Reviewofsymptoms of ULI:"+ULI+" not found");
        }
    }
    static class ReviewofsymptomsDuplicateFound extends Exception{
        public ReviewofsymptomsDuplicateFound(String errorMessage){
            super(errorMessage);
        }
        public ReviewofsymptomsDuplicateFound(){
            super("Reviewofsymptoms already exists");
        }
        public ReviewofsymptomsDuplicateFound(Integer id){
            super("Reviewofsymptoms of ID:"+id+" already exists");
        }
    }
}
