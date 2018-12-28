package com.globo.challenge.services.impl;

import com.globo.challenge.models.Test;
import com.globo.challenge.repository.TestRepository;
import com.globo.challenge.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Override
    public void testMethod() {

        Test t = new Test();
        t.setName("Caio");

        testRepository.insert(t);

    }
}
