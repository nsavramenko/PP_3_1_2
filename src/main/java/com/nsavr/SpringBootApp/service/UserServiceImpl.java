package com.nsavr.SpringBootApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nsavr.SpringBootApp.models.User;
import com.nsavr.SpringBootApp.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Transactional
    @Override
    public void saveUser(User user) {
        usersRepository.save(user);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User upatedUser) {
        upatedUser.setId(id);
        usersRepository.save(upatedUser);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> foundUser = usersRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Override
    public List<User> listUsers() {
        return usersRepository.findAll();
    }
}
