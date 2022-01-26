package com.jobHelper.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jobHelper.bean.Result;
import com.jobHelper.entity.UserEntity;
import com.jobHelper.service.UserService;
@Controller
public class UserController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping("/login")
//	public String toLogin() {
//		return "login";
//	}
	
//	@RequestMapping("/register")
//	public String toRegister() {
//		return "register";
//	}
	
	@RequestMapping("/userWelcome")
	public String toUserWelcome() {
		if(session.getAttribute("totalUser")!=null) {
			return "userWelcome";
		}
		return "errorWelcome";
	}
	
	@RequestMapping("/adminWelcome")
	public String toAdminWelcome() {
		if(session.getAttribute("totalUser")==null)return "errorWelcome";
		UserEntity user = (UserEntity)session.getAttribute("totalUser");
		if(user.getAdmin()!=null&&(user.getAdmin().equals("1")||user.getAdmin().equals("2"))) {
			return "adminWelcome";
		}
		return "adminError";
	}
	
	@RequestMapping("/userRegister")
	@ResponseBody
	public Result userRegister(@RequestBody UserEntity user) {
		user.setId(0);
		user.setAdmin("1");
		if(userService.saveRegisterUser(user)) {
			Result result = new Result(0, "注册成功", "", "/jobHelper/login");
			System.out.println(user.getUserName()+",注册成功");
			return result;
		}
		else {
			return new Result(-1, "用户名已存在", "", "");
		}
	}
	
	@RequestMapping("/userLogin")
	@ResponseBody
	public Result userLogin(@RequestBody UserEntity user) {
		if(userService.login(user)) {
			user = (UserEntity)session.getAttribute("totalUser");
			if(user.getAdmin()!=null&&user.getAdmin().equals("1")) {
				System.out.println("登入用户："+user.getUserName());
				return new Result(0, "登入成功", user, "/jobHelper/adminWelcome");
			}else if(user.getAdmin().equals("2")){
				System.out.println("登入用户："+user.getUserName());
				return new Result(0, "登入成功", user, "/jobHelper/pages/data");
			}
		}
		return new Result(-1, "账号密码错误", "", "");	
	}
	
	@RequestMapping("/signOut")
	public String signOut() {
		session.removeAttribute("totalUser");
		if(session.getAttribute("totalUser")==null) {
			return "login";
		}else {
			return null;
		}
	}
}
