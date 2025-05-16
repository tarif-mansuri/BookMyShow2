package com.tarif.BookMyShow2.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupUserRequestDTO {
    private String name;
    private String email;
    private String password;
}
