package com.kh.common.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

@Log
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	@Override
	public void handle(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		log.info("Access Denied Handler" + request.toString());
		log.info("Redirect.... ");
		
		response.sendRedirect("/accessError");
	}
}