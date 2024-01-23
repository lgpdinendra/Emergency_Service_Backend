package com.example.emergency.Repository;

import com.example.emergency.Model.PublicUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublicUserRepository extends MongoRepository<PublicUser,String> {

}
