package com.st.olm.cq.aws.impl;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.auth.BasicAWSCredentials;
import com.st.olm.cq.api.aws.AWSManager;

public class TestAWSManagerImpl {

	private static final Logger log = LoggerFactory
			.getLogger(TestAWSManagerImpl.class);

	private AWSManager awsMgr;

	@Before
	public void init() {
		awsMgr = new AWSManagerImpl();
		((AWSManagerImpl) awsMgr).setBucketName("st-app");
		((AWSManagerImpl) awsMgr).setCreds(new BasicAWSCredentials(
				"AKIAJEBLDT5AMFUWFFBQ",
				"LVR+Og1v7eityYpilOcfHW0cSWl3QxKAXEZoBj7v"));
	}

	@Test
	public void testGetS3File() throws IOException {
		try {
			awsMgr.getS3File("fake");
			fail("Didn't get expected IOException");
		} catch (IOException e) {
			log.info("Caught expected exception trying to get invalid file");
		}
	}
}
