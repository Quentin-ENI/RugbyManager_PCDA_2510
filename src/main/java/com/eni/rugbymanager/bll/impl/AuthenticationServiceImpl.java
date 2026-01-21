package com.eni.rugbymanager.bll.impl;

import com.eni.rugbymanager.bll.AuthenticationService;
import com.eni.rugbymanager.bo.UserInfo;
import com.eni.rugbymanager.dto.AuthenticationRequest;
import com.eni.rugbymanager.dto.AuthenticationResponse;
import com.eni.rugbymanager.repository.UserInfoRepository;
import com.eni.rugbymanager.security.jwt.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private AuthenticationManager authenticationManager;
    private UserInfoRepository userInfoRepository;
    private JwtService jwtService;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getPseudo(),
                        request.getPassword()
                )
        );

        UserInfo user = userInfoRepository.findById(request.getPseudo()).orElseThrow();

        String jwtToken = jwtService.generateToken(user);
        AuthenticationResponse authResponse = new AuthenticationResponse(jwtToken);

        return authResponse;
    }
}
