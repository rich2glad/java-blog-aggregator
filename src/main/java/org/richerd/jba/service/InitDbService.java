package org.richerd.jba.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;

import org.richerd.jba.entity.Blog;
import org.richerd.jba.entity.Item;
import org.richerd.jba.entity.Role;
import org.richerd.jba.entity.User;
import org.richerd.jba.repository.BlogRepository;
import org.richerd.jba.repository.ItemRepository;
import org.richerd.jba.repository.RoleRepository;
import org.richerd.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository ;
	
	@PostConstruct
	public void init(){
		Role roleUSer= new Role();
		roleUSer.setName("ROLE_USER");
		roleRepository.save(roleUSer);
		
		Role roleAdmin= new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String encode = encoder.encode("admin");
		userAdmin.setPassword(encode);
		userAdmin.setEnabled(true);
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUSer);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		User userAdmin1 = new User();
		userAdmin1.setName("user");
		userAdmin1.setPassword(encoder.encode("user"));
		userAdmin1.setEnabled(true);
		List<Role> roles1 = new ArrayList<Role>();
		roles1.add(roleAdmin);
		userAdmin1.setRoles(roles1);
		userRepository.save(userAdmin1);
		
		Blog blog= new Blog();
		blog.setName("richerd");
		blog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blog.setUser(userAdmin);
		blogRepository.save(blog);
		
		Item item1 = new Item();
		item1.setBlog(blog);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setPublishDate(new Date());
		
		Item item2 = new Item();
		item2.setBlog(blog);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishDate(new Date());
		
		itemRepository.save(item1);
		itemRepository.save(item2);
		
		
		
	}

}
