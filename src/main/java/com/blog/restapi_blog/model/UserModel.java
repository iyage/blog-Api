package com.blog.restapi_blog.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private  int id;
    @NotEmpty
    @Size(min = 4,max = 25,message = "First name can not be empty and must be between 4-25 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 4,max = 25,
            message = "Last name can not be empty and must be between 4-25 characters")
    private  String lastName;
    @NotEmpty
    @Size(min = 4,max = 7,
            message = "username can not be empty and must be 4-7 character")
    private  String username;
    @Email(message = "Only email pattern is allowed")
    @NotEmpty(message = "email can not be empty")
    private String email;
    private  String password;
}
