package com.xperphile.userservice.repository;

import com.xperphile.userservice.dao.UserFav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserFavRepository extends JpaRepository<UserFav, String> {

    @Query("select c from UserFav c where c.user_id like ?1")
    UserFav findUserFavByUser_Id(String user_id);

    @Query("delete from UserFav c where c.user_id like ?1")
    void deleteByUser_Id(String user_id);

}
