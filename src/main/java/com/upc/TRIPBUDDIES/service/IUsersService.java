package com.upc.TRIPBUDDIES.service;

import com.upc.TRIPBUDDIES.entities.users;

import java.util.List;

public interface IUsersService extends CrudService<users> {

        users findByEmail(String email) throws Exception;

        List<users> findByFirstName(String firstName) throws Exception;

        List<users> findByRole(String role) throws Exception;

}
