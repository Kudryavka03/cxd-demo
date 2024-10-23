package com.cxd.service;


import com.cxd.model.Users;
import com.cxd.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.time.LocalDateTime;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUser(Users user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return usersRepository.save(user); 
       //save()方法如果传入的对象是一个新的实体（即没有主键或主键为 null），则会将其插入到数据库中，并返回一个包含生成的主键的新对象。
    }
    
    /*
    	新增一个方法getUserByID(),根据给的用户编号参数，返回一个Optional容器，
     	1、如果找到该用户，容器里装着这个个Users对象
     	2、如果找不到改编号的用户，容器里留空
     */
    public Optional<Users> getUserByID(Long id) {
        return usersRepository.findById(id);
    }
    public boolean deleteUserByID(Long id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
