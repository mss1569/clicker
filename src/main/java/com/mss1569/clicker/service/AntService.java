package com.mss1569.clicker.service;

import com.mss1569.clicker.domain.Ant;
import com.mss1569.clicker.exception.ObjectFoundException;
import com.mss1569.clicker.exception.ObjectNotFoundException;
import com.mss1569.clicker.repository.AntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AntService {
    @Autowired
    private AntRepository antRepository;

    public Ant findById(long id) {
        return antRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Ant not found"));
    }

    public Ant findByUserUsername(String username) {
        return Optional.ofNullable(antRepository.findByUserUsername(username))
                .orElseThrow(() -> new ObjectNotFoundException("Ant not found"));
    }

    public Ant click(Ant ant){
        ant.click();
        return antRepository.save(ant);
    }

    public Ant upgrade(Ant ant){
        ant.upgrade();
        return antRepository.save(ant);
    }

    @Transactional
    public Ant save(Ant ant) {
        if (antRepository.existsByUserId(ant.getUser().getId()))
            throw new ObjectFoundException("User cannot have two ants");

        return antRepository.save(ant);
    }

    public void delete(long id) {
        antRepository.delete(findById(id));
    }
}
