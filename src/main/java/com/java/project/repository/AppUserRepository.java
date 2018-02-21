package com.java.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.java.project.dao.AppUser;

public interface AppUserRepository extends MongoRepository<AppUser, String> {

	AppUser findByUsername( String username );
}
