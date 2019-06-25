package com.xperphile.userservice.repository;

import com.xperphile.userservice.dao.UserFollower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface UserFollowerRepository extends JpaRepository<UserFollower, String> {

    @Query("select c.follower_id from UserFollower c where c.user_id like ?1")
    List<String> getFollower_IdsByUser_Id(String user_id);

    @Query("select c.user_id from UserFollower c where c.follower_id like ?1")
    List<String> getUser_IdsByFollower_Id(String follower_id);

    @Query("delete from UserFollower c where c.user_id like ?1")
    void deleteByUser_Id(String user_id);

    @Query("delete from UserFollower c where c.follower_id like ?1")
    void deleteByFollower_Id(String follower_id);

}
