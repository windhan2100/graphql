package com.hanchao.graphql.graphql.repo;

import com.hanchao.graphql.graphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hanliwei
 * @create 2019-03-02 11:18
 */
public interface UserRepo extends JpaRepository<User,Long> {
    /**
     * @descript: 通过用户名查找用户
     * @auther: hanliwei
     * @date: 2019/3/2 11:29
     * @param name  用户名
     * @return User
     */
    User findUserByName(String name);


}
