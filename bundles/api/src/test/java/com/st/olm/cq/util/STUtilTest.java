package com.st.olm.cq.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class STUtilTest {

	private static final Logger log = LoggerFactory.getLogger(STUtilTest.class);

	@Test
	public void testToPath() {
		log.info("testToPath");

		log.info("Testing basic conversion");
		assertEquals("my-arbitrary-name", STUtil.toPath("My Arbitrary Name"));

		log.info("Testing handling of multiple whitespace");
		assertEquals("my-arbitrary-name", STUtil.toPath("My Arbitrary   Name"));

		log.info("Testing handling of non-alphanumeric");
		assertEquals("my-arbitrary-name", STUtil.toPath("My Arbitrary  @Name"));

		log.info("Testing handling of non-ASCII Alpha Characters");
		assertEquals("my-arbitrary-e-name",
				STUtil.toPath("My Arbitrary  ÈName"));

		log.info("Testing handling of whitespace at the end of the string");
		assertEquals("my-arbitrary-e-name",
				STUtil.toPath("My Arbitrary  ÈName "));

		log.info("Tests successful");
	}

	@Test
	public void testCreatePathFromUUID() {

		log.info("testCreatePathFromUUID");

		log.info("Testing createPathFromUUID");

		assertNotNull(STUtil.createPathFromUUID());
		assertTrue(STUtil
				.createPathFromUUID()
				.matches("^[0-9a-f]{2}/[0-9a-f]{2}/[0-9a-f]{2}/[0-9a-f]{2}/[0-9a-f]{2}/[0-9a-f]{2}/[0-9a-f]{2}/[0-9a-f]{2}/$"));

	}
}
