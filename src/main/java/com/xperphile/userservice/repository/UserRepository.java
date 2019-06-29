package com.xperphile.userservice.repository;

import com.xperphile.userservice.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select c from User c where c.username like %?1%")
    List<User> findByUsername(String username);

    @Query("select c from User c where c.email like ?1")
    User findByEmail(String email);

}
