package com.api.airport.domain.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.api.airport.domain.dto.UserDTO;
import com.api.airport.domain.entity.FlightEntity;
import com.api.airport.domain.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserRepositoryImpl implements UserRepository{
    private final DynamoDBMapper dynamoDBMapper;

    public UserRepositoryImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public void createUser(UserEntity userEntity) {
        dynamoDBMapper.save(userEntity);
    }

    @Override
    public UserEntity getUserByUserId(String userId) {
        UserEntity response = dynamoDBMapper.load(UserEntity.class, userId);
        if (response == null){
            throw new NullPointerException();
        }
        return response;
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        dynamoDBMapper.save(userEntity);
    }

    @Override
    public void deleteUser(UserEntity userEntity) {
        dynamoDBMapper.delete(userEntity);
    }
}
