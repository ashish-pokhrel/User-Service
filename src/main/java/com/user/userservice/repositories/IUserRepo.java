package com.user.userservice.repositories;

import com.user.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
    @Query("select  u from User u Where u.Username =:username")
    User getUserByUserName(@Param("username") String username);

    @Query("select u.Role from User u Where u.Id =:id")
    String getRoleById(long id);
}
