package org.richerd.jba.service;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.richerd.jba.entity.Item;
import org.richerd.jba.exception.RssException;

public class RssServiceTest {

	
	RssService rssService;
	
	@Before
	public void setUp()throws Exception{
		rssService = new RssService();
	}
	
	@Test
	public void testGetItemsFile() throws RssException {
		List<Item> items =  rssService.getItems(new File("test-rss/javavids.xml"));
		assertEquals(10, items.size());
		Item item =  items.get(0);
		assertEquals("10", item.getPublishDate());
		//System.out.println(item.getPublishDate());
		//System.out.println(item.getTitle());
	}

}
