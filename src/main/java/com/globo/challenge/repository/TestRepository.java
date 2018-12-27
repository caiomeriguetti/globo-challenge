package com.globo.challenge.repository;

import com.globo.challenge.models.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Test, String> {

}