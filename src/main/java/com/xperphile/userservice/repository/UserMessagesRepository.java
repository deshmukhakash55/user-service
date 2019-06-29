package com.xperphile.userservice.repository;

import com.xperphile.userservice.dao.UserMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Component
@Repository
public interface UserMessagesRepository extends JpaRepository<UserMessages, String> {

    @Transactional
    @Modifying
    @Query("delete from UserMessages c where c.user_id like ?1")
    void deleteByUser_Id(String user_id);

    @Transactional
    @Modifying
    @Query("delete from UserMessages c where c.messager_id like ?1")
    void deleteByMessager_Id(String messager_id);

}
