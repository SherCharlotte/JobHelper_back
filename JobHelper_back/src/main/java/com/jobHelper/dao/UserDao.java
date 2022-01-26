package com.jobHelper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobHelper.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long> {
	UserEntity findByUserNameAndUserPassword(String userName,String userPassword);
	UserEntity findByUserName(String username);	
}
