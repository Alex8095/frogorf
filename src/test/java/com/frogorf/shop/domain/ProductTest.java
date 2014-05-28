package com.frogorf.shop.domain;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductTest {

	private static final Logger logger = LoggerFactory.getLogger(ProductTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		// Date date = new Date();
		// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		// String formattedDate = dateFormat.format(date);
		// model.addAttribute("serverTime", formattedDate );

		DateTime dateCreate = new DateTime();
		DateTime dateUpdate = new DateTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		Product item = new Product();
		item.setUrl("url");
		item.setIsHot(false);
		item.setIsShow(false);
		item.setPrice(1000.0);
		item.setOldPrice(800.0);
		item.setDateCreate(dateCreate);
		item.setDateUpdate(dateUpdate);
		item.setCountInWarehouse(10L);

		logger.info(item.toString());

		assertEquals(item.getUrl(), "url");
		assertEquals(item.getIsHot(), false);
		assertEquals(item.getIsShow(), false);
		assertEquals(item.getPrice(), (Double) 1000.0);
		assertEquals(item.getOldPrice(), (Double) 800.0);
		assertEquals(item.getDateCreate(), dateCreate);
		assertEquals(item.getDateCreateString(), sdf.format(dateCreate.toDate()));
		assertEquals(item.getDateUpdate(), dateUpdate);
		assertEquals(item.getDateUpdateString(), sdf.format(dateUpdate.toDate()));
		assertEquals(item.getCountInWarehouse(), (Long) 10L);

	}

}
