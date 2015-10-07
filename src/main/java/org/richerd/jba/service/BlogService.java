package org.richerd.jba.service;

import org.richerd.jba.entity.Blog;
import org.richerd.jba.entity.User;
import org.richerd.jba.repository.BlogRepository;
import org.richerd.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void save(Blog blog, String name) {

		User user =userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		
	}

	public void delete(int id) {
		blogRepository.delete(id);
		
	}

	public Blog findOne(int id) {
		// TODO Auto-generated method stub
		return blogRepository.findOne(id);
	}

	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog")Blog blog) {
		blogRepository.delete(blog);
		
	}

}
