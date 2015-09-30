package org.richerd.jba.repository;

import org.richerd.jba.entity.Item;
import org.richerd.jba.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
