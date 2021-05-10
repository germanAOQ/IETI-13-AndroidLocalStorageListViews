package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.*;

import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public interface UserService
{
    List<User> getUsers();

    User getUser( String id );

    User createUser( User user );


}