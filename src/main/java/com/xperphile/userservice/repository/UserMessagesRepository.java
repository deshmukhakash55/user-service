package com.xperphile.userservice.repository;

import com.xperphile.userservice.dao.UserMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserMessagesRepository extends JpaRepository<UserMessages, String> {

    @Query("delete from UserMessages c where c.user_id like ?1")
    void deleteByUser_Id(String user_id);

    @Query("delete from UserMessages c where c.messager_id like ?1")
    void deleteByMessager_Id(String messager_id);

}
