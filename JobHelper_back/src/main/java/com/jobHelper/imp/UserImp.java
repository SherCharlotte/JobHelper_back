package com.jobHelper.imp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobHelper.dao.UserDao;
import com.jobHelper.entity.UserEntity;
import com.jobHelper.service.UserService;

@Service
public class UserImp implements UserService{
	
	@Autowired
	UserDao userDao;
	@Autowired
	HttpSession session;
	@Override
	public boolean login(UserEntity user) {
		// TODO Auto-generated method stub
		if(user.getUserName()==null||user.getUserPassword()==null) {
			return false;
		}
		else {
			user = userDao.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
		}
		
		if(user==null) {
			return false;
		}else {
			user.setUserPassword(null);
			session.setAttribute("totalUser", user);
			return true;
		}	
	}

	@Override
	public List<UserEntity> findUser(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveRegisterUser(UserEntity user) {
		// TODO Auto-generated method stub
		if(userDao.findByUserName(user.getUserName())==null) {
			userDao.save(user);
			return true;
		}
		else {
			System.out.println(user.getUserName()+"已存在");
			return false;
		}
		
	}

}
