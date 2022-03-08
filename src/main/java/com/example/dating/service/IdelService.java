package com.example.dating.service;

import com.example.dating.domain.Idel;
import com.example.dating.repository.IdelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdelService {

    @Autowired
    IdelRepository idelRepository;

    public Idel saveIdel(Idel idel) {
        return idelRepository.save(idel);
    }
}
