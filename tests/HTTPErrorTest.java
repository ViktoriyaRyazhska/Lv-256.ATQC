package edu.junit.tests;

import org.junit.Assert;
import org.junit.Test;

import edu.junit.HTTPError;
import edu.junit.HTTPErrorTask;

public class HTTPErrorTest {
	HTTPErrorTask hTTPError = new HTTPErrorTask();

	@Test
	public void testhTTPErrorMessage() {
		String hTTPErrorMessage = hTTPError.getErrorCodeMessage(404);
		Assert.assertEquals("The requested resource could not be found but may be available in the future",
				hTTPErrorMessage);

	}

	@Test
	public void testhTTPErrorMessage1() {
		String hTTPErrorMessage = hTTPError.getErrorCodeMessage(403);
		Assert.assertNotEquals("The requested resource could not be found but may be available in the future",
				hTTPErrorMessage);
	}

	@Test
	public void testhTTPErrorMessage2() {
		String hTTPErrorMessage = hTTPError.getErrorCodeMessage(202);
		Assert.assertNotEquals("\"Standard response for successful HTTP requests\"", hTTPErrorMessage);
	}

	@Test
	public void testhTTPErrorMessage3() {
		String hTTPErrorMessage = hTTPError.getErrorCodeMessage(403);
		Assert.assertEquals("The request was valid, but the server is refusing action", hTTPErrorMessage);

	}

	@Test
	public void testhTTPErrorMessage4() {
		String hTTPErrorMessage = hTTPError.getErrorCodeMessage(409);
		Assert.assertEquals(
				"Indicates that the request could not be processed because of conflict in the request, such as an edit conflict between multiple simultaneous updates",
				hTTPErrorMessage);

	}

}