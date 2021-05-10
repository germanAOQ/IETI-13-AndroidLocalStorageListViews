package com.eci.cosw.springbootsecureapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public enum RolesEnum
{
    ADMIN( "admin" ),
    USER( "user" );

    final String role;

    RolesEnum( String role )
    {
        this.role = role;
    }
    @Override
    public String toString(){
        return role;
    }

}
