package com.codeChallenge.codeChallenge.repository;


import java.util.List;

import com.codeChallenge.codeChallenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;





public interface UserRepository extends JpaRepository<User, Long>{


 List<User> findByEnabled(Boolean enabled);
}
