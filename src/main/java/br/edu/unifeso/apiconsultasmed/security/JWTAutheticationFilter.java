package br.edu.unifeso.apiconsultasmed.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.unifeso.apiconsultasmed.models.ClienteModel;

public class JWTAutheticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	
	private JWTUtil jwtUtil;
	
	public JWTAutheticationFilter() {
	}
	
	public JWTAutheticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			ClienteModel creds = new ObjectMapper().readValue(request.getInputStream(), ClienteModel.class);
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken
					(creds.getUsername(), creds.getSenha(), new ArrayList<>());
			Authentication auth = authenticationManager.authenticate(authToken);
			return auth;
		}
		catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String username = ((UserSS) auth.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username);
		
		System.out.println(token);

		
		response.addHeader("Authorization", "Bearer " + token);
	}

}