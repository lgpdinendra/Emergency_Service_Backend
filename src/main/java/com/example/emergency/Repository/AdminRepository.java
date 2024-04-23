package com.example.emergency.Repository;

import com.example.emergency.Model.Admin;
import com.example.emergency.Model.ServiceUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AdminRepository extends MongoRepository<Admin,String> {
    @Query("{email: ?0}")
    Admin getAdminByEmail(String email);
    Admin findAdminByEmail(String email);
}
