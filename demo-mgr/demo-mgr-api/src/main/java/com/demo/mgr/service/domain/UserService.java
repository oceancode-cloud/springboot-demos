package com.demo.mgr.service.domain;

import com.demo.mgr.repository.domain.UserRepository;

public interface UserService {
    UserRepository repository();
    UserRepository repository(boolean useBusinessRepository);
}