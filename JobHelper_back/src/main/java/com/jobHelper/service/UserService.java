package com.jobHelper.service;

import java.util.List;

import com.jobHelper.entity.UserEntity;

public interface UserService {
	public boolean login(UserEntity user);
	public List<UserEntity> findUser(UserEntity user);
	public boolean saveRegisterUser(UserEntity user);
}
