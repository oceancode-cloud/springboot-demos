package com.demo.mgr.repository.domain;

import com.oceancode.cloud.api.repository.ActionCallback;
import com.oceancode.cloud.api.repository.Rollback;
import com.oceancode.cloud.common.entity.ResultData;
import com.demo.mgr.model.domain.User;

import java.util.List;
import java.util.Set;

public interface UserRepository {
    User findById(Long id, boolean throwEx);

    User findById(Long id);

    List<User> findByIds(Set<Long> ids);

    List<User> findByIds(Set<Long> ids, boolean throwEx);

    List<User> findByIds(Long id, Long...ids);

    User findOne(User entity, boolean throwEx);

    User findOne(User entity);

    List<User> findAll();

    List<User> findAll(boolean throwEx);

    List<User> findAll(User entity);

    List<User> findAll(User entity, boolean throwEx);

    boolean addOne(User entity);

    boolean addOne(User entity, boolean throwEx);

    boolean addBatch(List<User> list);

    boolean addBatch(List<User> list, int batchSize);

    boolean deleteById(Long id, boolean throwEx);

    boolean deleteById(Long id);

    boolean updateById(User entity);

    boolean updateById(User entity, boolean throwEx);

    boolean updateBatchById(List<User> list);

    boolean updateBatchById(List<User> list, int batchSize);

    boolean existsById(Long id);

    boolean existsByIds(Set<Long> ids);

    List<User> findByPage(User entity, Integer page, Integer size);

    User findFieldByUsername(String username);

    User findFieldByUsername(String username, boolean throwEx);

    boolean transaction(Runnable runnable);

    boolean transaction(Runnable runnable, boolean throwEx);
}