package com.demo.mgr.mapper.master.domain;

import com.demo.mgr.model.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserMapper {
    int insertOne(User entity);

    User selectById(Long id);

    User selectByIdWithBusiness(User entity);

    List<User> selectByIdsWithBusinessField(@Param("list") Set<Long> list, @Param("session") User session);

    List<User> selectByIds(@Param("list") Set<Long> list);

    User selectOne(User entity);

    List<User> selectAll();

    List<User> selectAllByEntity(User entity);

    int deleteById(Long id);

    int deleteByIdWithBusiness(User entity);

    int updateById(User entity);

    int updateByIdWithBusiness(User entity);

    Integer existsById(Long id);

    int existsByIds(@Param("list") Set<Long> list);

    List<User> selectByPage(@Param("entity") User entity, @Param("offset") long offset, @Param("size") Integer size, @Param("lastId") Long lastId);

    User selectColumnByUsername(String username);

    User selectColumnByUsernameWithBusiness(User entity);

}