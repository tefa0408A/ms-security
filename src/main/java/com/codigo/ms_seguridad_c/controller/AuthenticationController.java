package com.codigo.ms_seguridad_c.controller;

import com.codigo.ms_seguridad_c.aggregates.request.SignInRefreshToken;
import com.codigo.ms_seguridad_c.aggregates.request.SignInRequest;
import com.codigo.ms_seguridad_c.aggregates.request.SignUpRequest;
import com.codigo.ms_seguridad_c.aggregates.response.SignInResponse;
import com.codigo.ms_seguridad_c.entity.Usuario;
import com.codigo.ms_seguridad_c.service.AuthenticationService;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/authentication/v1/")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signupuser")
    public ResponseEntity<Usuario> signUpUser(
            @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService
                .signUpUser(signUpRequest));
    }
    @PostMapping("/signupadmin")
    public ResponseEntity<Usuario> signUpAdmin(
            @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService
                .signUpAdmin(signUpRequest));
    }

    //OBTENER UN ACCESS TOKEN POR MEDIO DE LOGIN
    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> signIn(
            @RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService
                .signIn(signInRequest));
    }
    //OBTENER UN ACCESS TOKEN POR MEDIO DE REFRESHTOKEN
    @PostMapping("/refreshToken")
    public ResponseEntity<SignInResponse> signInRefresh(
            @RequestBody SignInRefreshToken signInRefreshToken){
        return ResponseEntity.ok(authenticationService
                .getTokenByRefresh(signInRefreshToken));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getALl(){
        return ResponseEntity.ok(authenticationService.todos());
    }

    @GetMapping("/clave")
    public ResponseEntity<String> getClaveFirma(){
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String dato = Base64.getEncoder().encodeToString(key.getEncoded());
        return ResponseEntity.ok(dato);
    }
}