package com.soufang.soufang.repository;

import com.soufang.soufang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 自动生成
    // select * from user where name = ${username}
    //
    // 生成因素： 类继承的 Repository 的泛型、方法名、方法参数、返回值
    //
    // 方法名：
    // find -> select * from user   // jpa 实际上不使用的 * ，而是把所有的属性展开
    // By -> where
    // Name -> name = ?
    //
    // 方法参数：
    // 根据方法名中的占位符数量依次读取参数列表， name = ? -> name = ${name}
    //
    // 返回值会与泛型的参数进行匹配，并且不止支持单个的 User
    // 还支持：
    // List<User>、Set<User> 代表的是查询的多个返回值
    // Optional<User> ，单个返回值，null 的时候给到用户的是 Optional.empty,否则给到的是 Optional.of
    // Page<User>，代表分页，只能与 Pageable 参数配合使用。
    Optional<User> findByName(String name);

    Optional<User> findByPhoneNumber(String phone);
}
