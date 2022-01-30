package com.api.airportsystem.domain.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "user_information")
public class UserEntity {

    @DynamoDBHashKey(attributeName = "user_id")
    @DynamoDBGeneratedUuid(value = DynamoDBAutoGenerateStrategy.CREATE)
    @DynamoDBAttribute
    private String userId;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute(attributeName = "user_email")
    private String userEmail;

    @DynamoDBAttribute
    private String password;

    @DynamoDBAttribute
    private String role;

    public UserEntity(String name, String userEmail, String role, String password) {
        this.name = name;
        this.userEmail = userEmail;
        this.role = role;
        this.password = password;
    }
}
