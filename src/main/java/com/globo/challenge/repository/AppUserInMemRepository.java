package com.globo.challenge.repository;

import com.globo.challenge.models.AppUserInMemory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserInMemRepository extends CrudRepository<AppUserInMemory, String> {


}
