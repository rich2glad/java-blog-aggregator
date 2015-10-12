package org.richerd.jba.service;

import java.util.ArrayList;
import java.util.List;

import org.richerd.jba.entity.Blog;
import org.richerd.jba.entity.Item;
import org.richerd.jba.entity.Role;
import org.richerd.jba.entity.User;
import org.richerd.jba.repository.BlogRepository;
import org.richerd.jba.repository.ItemRepository;
import org.richerd.jba.repository.RoleRepository;
import org.richerd.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(int id) {
		// TODO Auto-generated method stub
		User user = userRepository.findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for(Blog blog:blogs){
			 List<Item> items= itemRepository.findByBlog(blog , new PageRequest(0, 10, Direction.ASC, "publishDate"));
			 blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		user.setEnabled(true);
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEnabled(true);
		userRepository.save(user);
		
	}

	public User findOneWithBlogs(String name) {
		User user = userRepository.findByName(name);
		return findOneWithBlogs(user.getId());
	}

	public void delete(int id) {
		userRepository.delete(id);
		
	}

	public User findOne(String username) {
		return  userRepository.findByName(username);
		
	}
	
}
