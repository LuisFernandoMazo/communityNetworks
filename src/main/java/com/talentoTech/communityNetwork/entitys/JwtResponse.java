package com.talentoTech.communityNetwork.entitys;

public class JwtResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public JwtResponse(String token) {
        this.token = token;
    }
}
