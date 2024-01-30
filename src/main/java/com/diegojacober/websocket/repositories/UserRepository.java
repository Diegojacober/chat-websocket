package com.diegojacober.websocket.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diegojacober.websocket.entities.Status;
import com.diegojacober.websocket.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public List<User> findAllByStatus(Status status);
}
