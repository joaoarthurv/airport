package com.api.airportsystem.domain.repository;

import com.api.airportsystem.domain.entity.UserEntity;

public interface UserRepository {
    void createUser(UserEntity userEntity);

    UserEntity getUserByUserId(String userId);

    void updateUser(UserEntity userEntity);

    void deleteUser(UserEntity userEntity);
}
