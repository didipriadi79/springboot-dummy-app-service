package com.priadi.dummyapp.repository;

import com.priadi.dummyapp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsernameAndPassword(String username, String password);
}
