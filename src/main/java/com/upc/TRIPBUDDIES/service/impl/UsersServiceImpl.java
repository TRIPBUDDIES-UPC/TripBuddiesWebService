package com.upc.TRIPBUDDIES.service.impl;

import com.upc.TRIPBUDDIES.entities.users;
import com.upc.TRIPBUDDIES.repository.IUsersRepository;
import com.upc.TRIPBUDDIES.service.IUsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersServiceImpl implements IUsersService {
    private final IUsersRepository usersRepository;
    public UsersServiceImpl(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    @Transactional
    public users save(users users) throws Exception {
        return usersRepository.save(users);

    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        usersRepository.deleteById(id);
    }

    @Override
    public List<users> getAll() throws Exception {
        return usersRepository.findAll();
    }

    @Override
    public Optional<users> getById(Long id) throws Exception {
        return usersRepository.findById(id);
    }

    @Override
    public users findByEmail(String email) throws Exception {
        return usersRepository.findByEmail(email);
    }

    @Override
    public List<users> findByFirstName(String firstName) throws Exception {
        return usersRepository.findByFirstName(firstName);
    }

    @Override
    public List<users> findByRole(String role) throws Exception {
        return usersRepository.findByRole(role);
    }


}
