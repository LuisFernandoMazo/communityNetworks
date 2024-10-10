package com.talentoTech.communityNetwork.entitys;

public class Rol {
    private int idRol;
    private String nombreRol;

    public Rol(int idRol) {
        this.idRol = idRol;
        this.nombreRol = getRoleNameById(idRol);
    }

    public int getIdRole() {
        return idRol;
    }

    private String getRoleNameById(int idRole) {
        return switch (idRole) {
            case 1 -> "User";
            case 2 -> "Admin";
            case 3 -> "Manager";
            default -> "Unknown";
        };
    }

    public String getNombreRol() {
        return nombreRol;
    }
}
