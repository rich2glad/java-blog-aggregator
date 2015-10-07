package org.richerd.jba.repository;

import org.richerd.jba.entity.Role;
import org.richerd.jba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);

}
