package com.avatao.UserDataApi.repository;

import com.avatao.UserDataApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
