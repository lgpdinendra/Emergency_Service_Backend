package com.example.emergency.Repository;

import com.example.emergency.Model.ServiceUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ServiceUserRepository extends MongoRepository<ServiceUser,String> {
    @Query("{email: ?0}")
    ServiceUser getServiceUserByEmail(String email);
    ServiceUser findServiceUserByEmail(String email);
    void deleteByEmail(String email);
    boolean existsByEmail(String email);

    List<ServiceUser> findServiceUsersByServiceType(String serviceType);

}
