package com.st.olm.cq.util;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PathCollectorTest {

	private static final Logger log = LoggerFactory
			.getLogger(PathCollectorTest.class);

	@Test
	public void basicPathCollectorTest() {
		log.info("basicPathCollectorTest");

		String path = "/content/mypage";
		PathCollector pc = new PathCollector();
		pc.collect(path);

		List<String> paths = pc.getPaths();
		assertTrue("Paths list is the wrong size " + paths.size(),
				paths.size() == 1);
		assertTrue("Paths list does not contain expected path",
				paths.contains(path));

		log.info("Test successful");
	}

	@Test
	public void existingParentTest() {
		log.info("existingParentTest");

		String path = "/content/mypage";
		PathCollector pc = new PathCollector();
		pc.collect(path);
		pc.collect("/content/mypage/page2");

		List<String> paths = pc.getPaths();
		assertTrue("Paths list is the wrong size " + paths.size(),
				paths.size() == 1);
		assertTrue("Paths list does not contain expected path",
				paths.contains(path));
		log.info("Test successful");
	}

	@Test
	public void NewParentTest() {
		log.info("existingParentTest");

		String path = "/content/mypage";
		PathCollector pc = new PathCollector();
		pc.collect("/content/mypage/page2");
		pc.collect(path);

		List<String> paths = pc.getPaths();
		assertTrue("Paths list is the wrong size " + paths.size(),
				paths.size() == 1);
		assertTrue("Paths list does not contain expected path",
				paths.contains(path));
		log.info("Test successful");
	}
}
