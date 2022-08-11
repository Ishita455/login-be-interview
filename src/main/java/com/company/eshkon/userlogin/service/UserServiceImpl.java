package com.company.eshkon.userlogin.service;

import com.company.eshkon.userlogin.dto.ErrorDTO;
import com.company.eshkon.userlogin.dto.UserDTO;
import com.company.eshkon.userlogin.entity.UserEntity;
import com.company.eshkon.userlogin.exception.BusinessException;
import com.company.eshkon.userlogin.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO register(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        userEntity = userRepository.save(userEntity);
        BeanUtils.copyProperties(userEntity, userDTO);
        userDTO.setPassword(null);
        return userDTO;
    }

    @Override
    public UserDTO login(UserDTO userDTO) {

        Optional<UserEntity> optUserEntity = userRepository.findByUserNameAndPassword(userDTO.getUserName(), userDTO.getPassword());
        optUserEntity.orElseThrow(()-> {
            ErrorDTO errorDTO = new ErrorDTO("AUTH_001", "Invalid Credentials");
            List<ErrorDTO> errorDTOList = new ArrayList<>();
            errorDTOList.add(errorDTO);
            return new BusinessException(errorDTOList);
        });
        BeanUtils.copyProperties(optUserEntity.get(), userDTO);
        userDTO.setPassword(null);
        return userDTO;
    }
}
