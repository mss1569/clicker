package com.mss1569.clicker.service;

import com.mss1569.clicker.domain.Ant;
import com.mss1569.clicker.exception.ObjectNotFoundException;
import com.mss1569.clicker.repository.AntRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AntService {
    private final AntRepository antRepository;

    public Ant findById(long id) {
        return antRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Ant not found"));
    }

    @Transactional
    public Ant save(Ant ant) {
        return antRepository.save(ant);
    }

    public void delete(long id) {
        antRepository.delete(findById(id));
    }
}
