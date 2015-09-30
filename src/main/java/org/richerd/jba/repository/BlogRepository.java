package org.richerd.jba.repository;

import org.richerd.jba.entity.Blog;
import org.richerd.jba.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

}
