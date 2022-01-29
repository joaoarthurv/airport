package com.api.airport.domain.repository;

import com.api.airport.domain.entity.UserEntity;

public interface UserRepository {
    void createUser(UserEntity userEntity);

    UserEntity getUserByUserId(String userId);

    void updateUser(UserEntity userEntity);

    void deleteUser(UserEntity userEntity);
}
