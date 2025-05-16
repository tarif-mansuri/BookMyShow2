package com.tarif.BookMyShow2.dtos;

import com.tarif.BookMyShow2.models.User;
import lombok.Data;

@Data
public class UserResponseDTO {
    private User user;
    private ResponseStatus status;

}
