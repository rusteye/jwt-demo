package com.rusteye.jwtdemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 客户端将token封装在请求头中，格式为（Bearer后加空格）：Authorization：Bearer +token
		final String authHeader = request.getHeader("Authorization");
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			throw new Exception("Missing or invalid Authorization header.");
		}

		// 去除"Bearer "以后剩下的部分
		final String token = authHeader.substring(7);

		try {
			// 解密token，拿到里面的对象claims
			final Claims claims = jwtUtil.parseToken(token);
			// 将对象传递给下一个请求
			request.setAttribute("claims", claims);
		} catch (final SignatureException e) {
			throw new Exception("Invalid token.");
		}
		return true;
	}
}
