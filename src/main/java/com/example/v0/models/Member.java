package com.example.v0.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Member extends User{
    Date membershipDate;
}
