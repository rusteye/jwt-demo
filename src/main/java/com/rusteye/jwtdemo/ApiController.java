package com.rusteye.jwtdemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ApiController {
	@PostMapping("/api/test")
    public String test(HttpServletRequest request) throws ServletException {
		log.info(request.getAttribute("claims").toString());
        return "test success";
    }
}
