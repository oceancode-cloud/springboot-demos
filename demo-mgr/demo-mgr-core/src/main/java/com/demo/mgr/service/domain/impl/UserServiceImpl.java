package com.demo.mgr.service.domain.impl;

import com.demo.mgr.repository.domain.UserRepository;
import com.demo.mgr.service.domain.UserService;

import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository repository;

    @Override
    public UserRepository repository() {
        return repository;
    }

    @Override
    public UserRepository repository(boolean useBusinessRepository) {
        return repository;
    }
}