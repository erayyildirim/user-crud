package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created on 02-December-2018
 *
 * @author eray
 */
public interface UserRepository extends CrudRepository<User,Integer> {
}
