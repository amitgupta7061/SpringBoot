package com.biterush.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String fullName;
    private String email;
    private String password;
    private String image = "";
    private String address = "";
    private String gender = "";
    private String dob = "";
    private String phone = "";
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
