package com.diegojacober.websocket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegojacober.websocket.entities.Status;
import com.diegojacober.websocket.entities.User;
import com.diegojacober.websocket.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        user.setStatus(Status.ONLINE);
        return repository.save(user);
    }

    public void disconnect(User user) {
        var storedUser = repository.findById(user.getNickname()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            repository.save(storedUser);
        }
    }

    public List<User> findConnectedUsers() {
        return repository.findAllByStatus(Status.ONLINE);
    }
}
