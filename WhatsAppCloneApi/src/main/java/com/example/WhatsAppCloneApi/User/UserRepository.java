package com.example.WhatsAppCloneApi.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<user,String> {
@Query(name = UserConstants.FIND_USER_BY_EMAIL)
    Optional<user> findByEmail(@Param("email") String userEmail);

    @Query(name = UserConstants.FIND_ALL_USERS_EXCEPT_SELF)
    List<user> findAllUsersExceptSelf(@Param("publicId") String publicId);

    @Query(name = UserConstants.FIND_USER_BY_PUBLIC_ID)
    Optional<user> findByPublicId(@Param("publicId") String senderId);
}
