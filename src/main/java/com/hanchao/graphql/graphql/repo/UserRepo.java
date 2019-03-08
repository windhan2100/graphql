package com.hanchao.graphql.graphql.repo;

import com.hanchao.graphql.graphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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

    User findUserByEmail(String email);

    User findUserByEmailAndPwd(String email,String pwd);

    /**
     * @descript: 仅仅是为了测试
     * @auther: hanliwei
     * @date: 2019/3/7 21:20
     * @return
     */
    @Query(nativeQuery = true,value = " SELECT * FROM user ")
    List<User> findWithTable(@Param("t") String t);
}
