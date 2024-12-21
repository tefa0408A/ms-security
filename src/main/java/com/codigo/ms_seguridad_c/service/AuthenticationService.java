package com.codigo.ms_seguridad_c.service;

import com.codigo.ms_seguridad_c.aggregates.request.SignInRefreshToken;
import com.codigo.ms_seguridad_c.aggregates.request.SignInRequest;
import com.codigo.ms_seguridad_c.aggregates.request.SignUpRequest;
import com.codigo.ms_seguridad_c.aggregates.response.SignInResponse;
import com.codigo.ms_seguridad_c.entity.Usuario;

import java.util.List;

public interface AuthenticationService {

    //SIGNUP
    Usuario signUpUser(SignUpRequest signUpRequest);
    Usuario signUpAdmin(SignUpRequest signUpRequest);
    List<Usuario> todos();

    SignInResponse signIn(SignInRequest signInRequest);
    SignInResponse getTokenByRefresh(SignInRefreshToken signInRefreshToken);
}
