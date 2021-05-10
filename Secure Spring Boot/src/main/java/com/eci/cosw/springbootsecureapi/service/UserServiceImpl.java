package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.*;
import com.eci.cosw.springbootsecureapi.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl
    implements UserService
{

    private Map<String, User> users = new HashMap<>();


    @Autowired
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        //La contraseña es 123
        User user = new User( "test@mail.com", "202cb962ac59075b964b07152d234b70", "Andres", "Perez" );
        user.setRole( RolesEnum.USER );
        users.put( user.getEmail(), user );
    }


    @Override
    public List<User> getUsers()
    {
        return new ArrayList<>( users.values() );
    }

    @Override
    public User getUser( String id )
    {
        return users.get( id );
    }


    @Override
    public User createUser( User user )
    {
        user.setPassword( StringUtils.getMD5Hash( user.getPassword() ) );
        users.put( user.getEmail(), user );
        return user;
    }


}
