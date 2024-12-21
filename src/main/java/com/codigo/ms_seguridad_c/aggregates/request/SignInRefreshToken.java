package com.codigo.ms_seguridad_c.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRefreshToken {
    private String refreshToken;
}
