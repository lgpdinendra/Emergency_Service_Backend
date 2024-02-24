package com.example.emergency.Repository;

import com.example.emergency.Model.PublicUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PublicUserRepository extends MongoRepository<PublicUser,String> {

    @Query("{email: ?0}")
    PublicUser getPublicUserByEmail(String email);

    PublicUser findPublicUserByEmail(String email);

    void deleteByEmail(String email);

    boolean existsByEmail(String email);
}
