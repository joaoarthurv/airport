package com.api.airport.application.service;

import com.api.airport.domain.dto.UserDTO;
import com.api.airport.domain.entity.UserEntity;
import com.api.airport.domain.repository.UserRepository;
import com.api.airport.infrastructure.exception.AirportException;
import com.api.airport.infrastructure.exception.ErrorCodeDescription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDTO userDTO) {
        userRepository.createUser(convertToUserEntity(userDTO));
    }

    private UserEntity convertToUserEntity(UserDTO userDTO) {
        return new UserEntity(userDTO.getName(), userDTO.getUserEmail(), userDTO.getRole(),
                userDTO.getPassword());
    }

    public UserDTO getUserByUserId(String userId) {
        try {
            return convertToUserDTO(userRepository.getUserByUserId(userId));
        } catch (Exception e) {
            log.error("[UserService] - Error on function getUser. UserId: {}", userId);
            throw new AirportException(ErrorCodeDescription.NOT_FOUND_USER);
        }
    }

    private UserDTO convertToUserDTO(UserEntity userEntity) {
        return new UserDTO(userEntity.getUserId(), userEntity.getName(), userEntity.getUserEmail(), userEntity.getPassword(),
                userEntity.getRole());
    }

    public void updateUser(UserDTO userDTO, String userId) {
        try {
            var response = userRepository.getUserByUserId(userId);
            var toUpdate = convertToUserEntity(userDTO);
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
