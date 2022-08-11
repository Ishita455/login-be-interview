package com.company.eshkon.userlogin.service;

import com.company.eshkon.userlogin.dto.UserDTO;

public interface UserService {
    public UserDTO register(UserDTO userDTO);
    public UserDTO login(UserDTO userDTO);
}
