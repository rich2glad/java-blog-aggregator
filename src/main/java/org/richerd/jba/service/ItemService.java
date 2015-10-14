/**
 * 
 */
package org.richerd.jba.service;

import java.util.List;

import org.richerd.jba.entity.Item;
import org.richerd.jba.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * @author HP
 *
 */
@Service
public class ItemService {

	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getItems(){
		
		return itemRepository.findAll(new PageRequest(0, 20, Direction.DESC, "publishDate")).getContent();
	}
}
