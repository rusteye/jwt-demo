package com.rusteye.jwtdemo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private JwtUtil jwtUtil;
	
	// 模拟从数据库里取出来的数据
    private static List<User> userList = new ArrayList<>();
    
    static {
    	User user = new User();
    	user.setUsername("swy");
    	userList.add(user);
    }
    

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody User user) throws ServletException {
    	String username = user.getUsername();
        if (username == null || !"swy".equals(username)) {
            throw new ServletException("Invalid login");
        }

        return jwtUtil.createToken("user", "admin");
    }

}