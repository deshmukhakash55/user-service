package com.xperphile.userservice.repository;

import com.xperphile.userservice.dao.UserBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Repository
public interface UserBlockRepository extends JpaRepository<UserBlock, String> {

    @Query("select c.blocked_id from UserBlock c where c.user_id like ?1")
    List<String> findBlocked_IdsByUser_Id(String user_id);

    @Transactional
    @Modifying
    @Query("delete from UserBlock c where c.user_id like ?1")
    void deleteByUser_Id(String user_id);

    @Transactional
    @Modifying
    @Query("delete from UserBlock c where c.blocked_id like ?1")
    void deleteByBlocked_Id(String blocked_id);

}
