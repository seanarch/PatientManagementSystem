package com.PatManSystem.main.Services;

import com.PatManSystem.main.Models.Abdomen;
import com.PatManSystem.main.Repository.AbdomenRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AbdomenServiceTest {

    private final AbdomenRepository abdomenRepository;

    @Autowired
    public AbdomenServiceTest(AbdomenRepository abdomenRepository){
        this.abdomenRepository = abdomenRepository;
    }

    @Test
    void getAbdomens() {

    }

    @Test
    void getAbdomen() {

        String testDescription = "testText1-- .";
        Integer testId = 1;
        Abdomen abdomen = new Abdomen(testId,testDescription);


        Optional<Abdomen> AbdomenTestEmpty = abdomenRepository.findById(testId);

        if(AbdomenTestEmpty.isPresent())
            abdomenRepository.deleteById(testId);

        assertEquals(Optional.empty(),AbdomenTestEmpty);

        abdomenRepository.save(abdomen);

        Optional<Abdomen> AbdomenTestNotEmpty = abdomenRepository.findById(testId);


        assertNotNull(AbdomenTestNotEmpty);
        assertEquals(testId, AbdomenTestNotEmpty.get().getId());
        assertEquals(testDescription, AbdomenTestNotEmpty.get().getDescription());

        abdomenRepository.deleteById(testId);
    }

    @Test
    void newAbdomen() {

        String testDescription = "testText2-- .";
        Integer testId = 1;
        Abdomen abdomen = new Abdomen(testId,testDescription);
        try {
            abdomenRepository.deleteById(testId);
        }catch(Exception ignored){

        }

        Optional<Abdomen> AbdomenTestEmpty = abdomenRepository.findById(testId);

        assertEquals(Optional.empty(),AbdomenTestEmpty);

        abdomenRepository.save(abdomen);

        Optional<Abdomen> AbdomenTestNotEmpty = abdomenRepository.findById(testId);


        assertNotNull(AbdomenTestNotEmpty);
        assertEquals(testId, AbdomenTestNotEmpty.get().getId());
        assertEquals(testDescription, AbdomenTestNotEmpty.get().getDescription());

        abdomenRepository.deleteById(testId);

    }

    @Test
    void deleteAbdomen() {

        String testDescription = "testText3-- .";
        Integer testId = 1;
        Abdomen abdomen = new Abdomen(testId,testDescription);

        Optional<Abdomen> AbdomenTestEmpty = abdomenRepository.findById(testId);

        if(AbdomenTestEmpty.isEmpty())
            abdomenRepository.save(abdomen);

        Optional<Abdomen> AbdomenTestNotEmpty = abdomenRepository.findById(testId);

        assertNotNull(AbdomenTestNotEmpty);
        assertEquals(testId, AbdomenTestNotEmpty.get().getId());
        assertEquals(testDescription, AbdomenTestNotEmpty.get().getDescription());

        abdomenRepository.deleteById(testId);

        AbdomenTestEmpty = abdomenRepository.findById(testId);

        assertEquals(Optional.empty(),AbdomenTestEmpty);

    }

    @Test
    void updateAbdomen() {

        String testDescription = "testText3-- .";
        String updateDescription = "Updated--3 test";
        Integer testId = 1;
        Abdomen abdomen = new Abdomen(testId,testDescription);

        Optional<Abdomen> AbdomenTestEmpty = abdomenRepository.findById(testId);

        if(AbdomenTestEmpty.isEmpty())
            abdomenRepository.save(abdomen);

        Optional<Abdomen> AbdomenTestUpdate = abdomenRepository.findById(testId);

        AbdomenTestUpdate.get().setDescription(updateDescription);

        abdomenRepository.save(AbdomenTestUpdate.get());

        AbdomenTestUpdate = abdomenRepository.findById(testId);

        assertEquals(updateDescription, AbdomenTestUpdate.get().getDescription());

        abdomenRepository.deleteById(testId);

    }
}