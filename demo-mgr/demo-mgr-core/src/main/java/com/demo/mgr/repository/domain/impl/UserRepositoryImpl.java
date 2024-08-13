package com.demo.mgr.repository.domain.impl;

import com.oceancode.cloud.api.repository.ActionCallback;
import com.oceancode.cloud.api.repository.Rollback;
import com.oceancode.cloud.common.config.CommonConfig;
import com.oceancode.cloud.common.constant.CommonConst;
import com.oceancode.cloud.common.entity.ResultData;
import com.oceancode.cloud.common.errorcode.CommonErrorCode;
import com.oceancode.cloud.common.exception.BusinessRuntimeException;
import com.oceancode.cloud.common.exception.ErrorCodeRuntimeException;
import com.oceancode.cloud.common.util.ValueUtil;
import com.demo.mgr.model.domain.User;
import com.demo.mgr.repository.domain.UserRepository;
import com.demo.mgr.mapper.master.domain.UserMapper;

import com.demo.mgr.util.SqlUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import jakarta.annotation.Resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.oceancode.cloud.common.util.Assert.checkResult;
import static com.oceancode.cloud.common.util.Assert.checkResultDataSize;
import static com.oceancode.cloud.common.util.Assert.notEmpty;
import static com.oceancode.cloud.common.util.Assert.notNull;

@Primary
@Component
public class UserRepositoryImpl implements UserRepository {
    @Resource
    private CommonConfig commonConfig;

    @Resource
    private UserMapper targetMapper;

    @Resource(name = "masterNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Resource(name = "masterPlatformTransactionManager")
    private PlatformTransactionManager transactionManager;

    @Resource(name = "masterSqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);

    private static int MAX_FETCH_DATA_SIZE = CommonConst.DEFAULT_RESULT_RECORDS_SIZE;

    @Override
    public User findById(Long id, boolean throwEx) {
        if (ValueUtil.isEmpty(id)) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_MISSING, "id must not be empty.");
        }
        if (id <= 0) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_INVALID, "id must be lager than 0");
        }
        return checkResult(targetMapper.selectById(id), CommonErrorCode.NOT_FOUND, throwEx, "id not found");
    }

    @Override
    public User findById(Long id) {
        return findById(id, true);
    }

    @Override
    public List<User> findByIds(Set<Long> ids, boolean throwEx) {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }
        ids = ids.stream().filter(item -> ValueUtil.isNotEmpty(item) && item > 0).collect(Collectors.toSet());
        if (ids.isEmpty()) {
            return Collections.emptyList();
        }
        if (ids.size() > 50) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_INVALID, "size too larger,max is 50");
        }
        List<User> list = targetMapper.selectByIds(ids);
        if (throwEx && list.isEmpty()) {
            throw new BusinessRuntimeException(CommonErrorCode.NOT_FOUND);
        }
        return list;
    }

    @Override
    public List<User> findByIds(Set<Long> ids) {
        return findByIds(ids, true);
    }

    @Override
    public List<User> findByIds(Long id, Long... ids) {
        Set<Long> idSet = new HashSet<>();
        idSet.add(id);
        if (Objects.nonNull(ids)) {
            for (Long it : ids) {
                idSet.add(it);
            }
        }
        return findByIds(idSet);
    }

    @Override
    public User findOne(User entity, boolean throwEx) {
        notNull(entity, CommonErrorCode.SERVER_ERROR, "the entity of the parameter which at selectOne method must not be null.");
        if (ValueUtil.isNotEmpty(entity.getId())) {
            return findById(entity.getId());
        }
        try {
            return checkResult(targetMapper.selectOne(entity), CommonErrorCode.NOT_FOUND, throwEx);
        } catch (Throwable e) {
            if (e.getCause() != null && e.getCause() instanceof org.apache.ibatis.exceptions.TooManyResultsException) {
                throw new BusinessRuntimeException(CommonErrorCode.TOO_MANY_RESULTS, e);
            } else {
                throw e;
            }
        }
    }

    @Override
    public User findOne(User entity) {
        return findOne(entity, true);
    }

    @Override
    public List<User> findAll(boolean throwEx) {
        List<User> list = targetMapper.selectAll();
        if (throwEx && list.isEmpty()) {
            throw new BusinessRuntimeException(CommonErrorCode.NOT_FOUND);
        }
        checkResultDataSize(list, MAX_FETCH_DATA_SIZE);
        return list;
    }

    @Override
    public List<User> findAll() {
        return findAll(false);
    }

    @Override
    public List<User> findAll(User entity, boolean throwEx) {
        notNull(entity, CommonErrorCode.SERVER_ERROR, "the entity of the parameter which at selectAll method must not be null.");
        if (ValueUtil.isNotEmpty(entity.getId())) {
            User o = findById(entity.getId());
            if (Objects.nonNull(o)) {
                List<User> list = new ArrayList<>();
                list.add(o);
                return list;
            } else {
                return Collections.emptyList();
            }
        }
        try {
            List<User> list = targetMapper.selectAllByEntity(entity);
            if (throwEx && list.isEmpty()) {
                throw new BusinessRuntimeException(CommonErrorCode.NOT_FOUND);
            }
            checkResultDataSize(list, MAX_FETCH_DATA_SIZE);
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<User> findAll(User entity) {
        return findAll(entity, false);
    }

    @Override
    public boolean addOne(User entity) {
        return addOne(entity, true);
    }

    @Override
    public boolean addOne(User entity, boolean throwEx) {
        notNull(entity, CommonErrorCode.SERVER_ERROR, "the entity of the parameter which at insertOne method must not be null.");
        populateAddFieldDomain(entity);
        boolean ret = targetMapper.insertOne(entity) == 1;
        if (throwEx && !ret) {
            throw new BusinessRuntimeException(CommonErrorCode.SERVER_ERROR);
        }
        return ret;
    }

    @Override
    public boolean addBatch(List<User> list) {
        return addBatch(list, 2000);
    }

    @Override
    public boolean addBatch(List<User> list, int batchSize) {
        return SqlUtil.batchUpdateOrInsert(sqlSessionFactory, list, UserMapper.class, (item, mapper) -> {
            populateAddFieldDomain(item);
            return mapper.insertOne(item);
        }, batchSize) == list.size();
    }

    @Override
    public boolean deleteById(Long id) {
        return deleteById(id, true);
    }

    @Override
    public boolean deleteById(Long id, boolean throwEx) {
        if (ValueUtil.isEmpty(id)) {
            throw new BusinessRuntimeException(CommonErrorCode.SERVER_ERROR, "id is required.");
        }
        if (id < 1) {
            return false;
        }
        boolean ret = targetMapper.deleteById(id) == 1;
        if (!ret && throwEx) {
            throw new BusinessRuntimeException(CommonErrorCode.NOT_FOUND);
        }
        return ret;
    }

    @Override
    public boolean updateById(User entity, boolean throwEx) {
        notNull(entity, CommonErrorCode.SERVER_ERROR, "the entity of the parameter which at updateById method must not be null.");
        if (ValueUtil.isEmpty(entity.getId())) {
            throw new BusinessRuntimeException(CommonErrorCode.SERVER_ERROR, "id must not be null");
        }
        populateUpdateFieldDomain(entity);
        boolean ret = targetMapper.updateById(entity) == 1;
        if (!ret && throwEx) {
            throw new BusinessRuntimeException(CommonErrorCode.ERROR, "update failed");
        }

        return ret;
    }

    @Override
    public boolean updateById(User entity) {
        return updateById(entity, true);
    }

    @Override
    public boolean updateBatchById(List<User> list) {
        return updateBatchById(list, 100);
    }

    @Override
    public boolean updateBatchById(List<User> list, int batchSize) {
        notEmpty(list, CommonErrorCode.SERVER_ERROR, "list not empty");
        for (User item : list) {
            if (Objects.isNull(item) || ValueUtil.isEmpty(item.getId())) {
                return false;
            }
        }
        return SqlUtil.batchUpdateOrInsert(sqlSessionFactory, list, UserMapper.class, (item, mapper) -> {
            populateAddFieldDomain(item);
            return mapper.updateById(item);
        }, batchSize) == list.size();
    }

    @Override
    public boolean existsById(Long id) {
        if (ValueUtil.isEmpty(id) || id <= 0) {
            return false;
        }
        Integer count = targetMapper.existsById(id);
        return Objects.nonNull(count) && count == 1;
    }

    @Override
    public boolean existsByIds(Set<Long> ids) {
        if (Objects.isNull(ids) || ids.isEmpty()) {
            return false;
        }
        for (Long id : ids) {
            if (ValueUtil.isEmpty(id) || id < 1) {
                return false;
            }
        }
        if (ids.size() > 50) {
            throw new BusinessRuntimeException(CommonErrorCode.SERVER_ERROR, "elements too many,max is 50");
        }
        return targetMapper.existsByIds(ids) == ids.size();
    }

    @Override
    public List<User> findByPage(User entity, Integer page, Integer size) {
        if (page == null) {
            throw new BusinessRuntimeException(CommonErrorCode.SERVER_ERROR, "page is required");
        }
        if (size == null) {
            throw new BusinessRuntimeException(CommonErrorCode.SERVER_ERROR, "size is required");
        }
        if (entity == null) {
            entity = new User();
        }
        if (page < 1) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_MISSING, "page invalid.");
        }
        if (size < 1) {
            throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_MISSING, "size invalid.");
        }
        if (size > 100) {
            throw new BusinessRuntimeException(CommonErrorCode.SERVER_ERROR, "size is too large");
        }
        long offset = (page - 1L) * size;
        Long lastId = entity.getId();
        if (lastId == null && offset > 9998) {
            // 180 = page=50 size = 20
            lastId = offset;
        }
        return targetMapper.selectByPage(entity, offset, size, lastId);
    }

    @Override
    public User findFieldByUsername(String username) {
        return findFieldByUsername(username, true);
    }

    @Override
    public User findFieldByUsername(String username, boolean throwEx) {
        if (ValueUtil.isEmpty(username)) {
            if (throwEx) {
                throw new BusinessRuntimeException(CommonErrorCode.PARAMETER_MISSING, "username is required.");
            }
            return null;
        }
        User result = targetMapper.selectColumnByUsername(username);
        notNull(result, CommonErrorCode.NOT_FOUND, "username:" + username + " not found");
        return result;
    }

    @Override
    public boolean transaction(Runnable runnable, boolean throwEx) {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setTimeout(10);
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
        try {
            transactionManager.commit(transactionStatus);
            runnable.run();
        } catch (Throwable throwable) {
            transactionManager.rollback(transactionStatus);
            if (throwEx) {
                throw throwable;
            }
        }
        return true;
    }

    @Override
    public boolean transaction(Runnable runnable) {
        return transaction(runnable, true);
    }

    public void populateAddFieldDomain(User entity) {
        entity.setCreatedAt(java.time.LocalDateTime.now());
        populateUpdateFieldDomain(entity);
    }

    public void populateUpdateFieldDomain(User entity) {
        entity.setUpdatedAt(java.time.LocalDateTime.now());
    }

}