package com.example.v0.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User extends BaseModel{
    String name;
    String phone;
    String password;
}
