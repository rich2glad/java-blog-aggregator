package org.richerd.jba.repository;

import java.util.List;

import org.richerd.jba.entity.Blog;
import org.richerd.jba.entity.Role;
import org.richerd.jba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	List<Blog>  findByUser(User user);

}
