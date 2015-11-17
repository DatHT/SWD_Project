package com.cathl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cathl.model.User;
import com.cathl.service.DataService;

/**
 * @author LinhVH
 *
 */
@Controller
@RequestMapping("/api/users")
public class RestController {

	@Autowired
	DataService dataService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<User> list() {
		return dataService.getUserList();

	}
}
