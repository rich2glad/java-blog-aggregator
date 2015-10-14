package org.richerd.jba.repository;

import java.util.List;

import org.richerd.jba.entity.Blog;
import org.richerd.jba.entity.Item;
import org.richerd.jba.entity.Role;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByBlog(Blog blog, Pageable pageable);
	
	Item findByBlogAndLink(Blog blog,String link);
	
}
