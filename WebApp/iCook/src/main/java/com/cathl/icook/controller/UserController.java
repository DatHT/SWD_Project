package com.cathl.icook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cathl.icook.entity.TblUser;
import com.cathl.icook.entity.UserDetail;
import com.cathl.icook.service.UserDetailService;
import com.cathl.icook.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailService userDetailService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("newUser") TblUser newUser, 
			@RequestParam(value = "txtfullName", required = false) String fullName,
			@RequestParam(value = "txtEmail", required = false) String email,
			@RequestParam(value = "txtRepassword", required = false) String rePassword,
			@RequestParam(value = "txtPhoneNum", required = false) String phoneNum,
			Model model) {
		if (newUser.getUserName() != null) {
			if(!newUser.getPassword().equals(rePassword)){
				model.addAttribute("wrongPassword", newUser);
				return "register";
			}
			if(userService.checkDubplicate(newUser.getUserName())==null){
			newUser.setRole(1);
			userService.createUser(newUser);
			model.addAttribute("user", newUser);
			UserDetail userDetail = new UserDetail(newUser.getUserName(), fullName, phoneNum, email);
			userDetailService.createUserDetail(userDetail);
			return "redirect:/Admin";
			}else{
				model.addAttribute("userNameDub", newUser);
			}
		}
		return "register";
	}
}
