package com.api.airport.application.service;

import com.api.airport.domain.dto.UserDTO;
import com.api.airport.domain.mapper.UserMapper;
import com.api.airport.domain.repository.UserRepository;
import com.api.airport.infrastructure.exception.ErrorCodeDescription;
import com.api.airport.infrastructure.exception.exceptions.AirportException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void createUser(UserDTO userDTO) {
        userRepository.createUser(userMapper.toUserEntityWithoutId(userDTO));
    }

    public UserDTO getUserByUserId(String userId) {
        try {
            return userMapper.toUserDTO(userRepository.getUserByUserId(userId));
        } catch (Exception e) {
            log.error("[UserService] - Error on function getUser. UserId: {}", userId);
            throw new AirportException(ErrorCodeDescription.NOT_FOUND_USER);
        }
    }

    public void updateUser(UserDTO userDTO, String userId) {
        try {
            var response = userRepository.getUserByUserId(userId);
            var toUpdate = userMapper.toUserEntityWithoutId(userDTO);
            toUpdate.setUserId(response.getUserId());
            userRepository.updateUser(toUpdate);
        } catch (Exception e) {
            log.error("[UserService] - Error on function updateUser. UserId: {}", userId);
            throw new AirportException(ErrorCodeDescription.BAD_REQUEST_FOR_UPDATE_USER);
        }
    }

    public void deleteUser(String userId) {
        try {
            userRepository.deleteUser(userRepository.getUserByUserId(userId));
        } catch (Exception e) {
            log.error("[UserService] - Error on function deleteUser. UserId: {}", userId);
            throw new AirportException(ErrorCodeDescription.BAD_REQUEST_FOR_DELETE_USER);
        }
    }
}
