package com.eni.rugbymanager.bll;

import com.eni.rugbymanager.dto.AuthenticationRequest;
import com.eni.rugbymanager.dto.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
