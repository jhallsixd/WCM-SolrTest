package com.st.olm.cq.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiValueMapWrapperTest {
	private static final Logger log = LoggerFactory
			.getLogger(PathCollectorTest.class);

	MultiValueMapWrapper mvmw = new MultiValueMapWrapper();

	@Before
	public void init() {
		Map<String, Object> m1 = new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;
			{
				put("name", "bob");
			}
		};
		Map<String, Object> m2 = new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;
			{
				put("name", "sue");
				put("category", "person");
			}
		};
		Map<String, Object> m3 = new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;
			{
				put("city", "Cincinnati");
			}
		};
		mvmw.add(new ValueMapDecorator(m1));
		mvmw.add(new ValueMapDecorator(m2));
		mvmw.add(new ValueMapDecorator(m3));
	}

	@Test
	public void testGet() {
		log.info("testGet");

		log.info("Testing retrieving overridden property on primary map");
		assertEquals("bob", mvmw.get("name"));
		assertEquals("bob", mvmw.get("name", "none"));
		assertEquals("bob", mvmw.get("name", String.class));

		log.info("Testing retrieving non-overridden property ");
		assertEquals("person", mvmw.get("category"));
		assertEquals("person", mvmw.get("category", "none"));
		assertEquals("person", mvmw.get("category", String.class));

		log.info("Testing retrieving deep non-overridden property ");
		assertEquals("Cincinnati", mvmw.get("city"));
		assertEquals("Cincinnati", mvmw.get("city", "none"));
		assertEquals("Cincinnati", mvmw.get("city", String.class));

		log.info("Testing non-existing properties");
		assertEquals("none", mvmw.get("name2", "none"));
		assertEquals(null, mvmw.get("name2", String.class));

		log.info("Get tests successful");
	}

	@Test
	public void testMapOps() {
		log.info("testMapOps");

		log.info("Testing keyset");
		Set<String> keys = new HashSet<String>() {
			private static final long serialVersionUID = 1L;
			{
				add("name");
				add("category");
				add("city");
			}
		};
		assertTrue(
				"Keyset " + mvmw.keySet() + " invalid",
				keys.containsAll(mvmw.keySet())
						&& mvmw.keySet().containsAll(keys));

		log.info("Testing values");
		Collection<String> values = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;
			{
				add("bob");
				add("person");
				add("Cincinnati");
			}
		};
		assertTrue(
				"Values " + mvmw.values() + " invalid",
				values.containsAll(mvmw.values())
						&& mvmw.values().containsAll(values));

		log.info("Testing contains key");
		assertTrue(mvmw.containsKey("name"));
		assertTrue(mvmw.containsKey("category"));
		assertTrue(mvmw.containsKey("city"));
		assertFalse(mvmw.containsKey("city2"));

		log.info("Testing contains value");
		assertTrue(mvmw.containsValue("bob"));
		assertFalse(mvmw.containsValue("sue"));
		assertFalse(mvmw.containsValue("city2"));

		log.info("Map Operations tests successful");
	}
}
