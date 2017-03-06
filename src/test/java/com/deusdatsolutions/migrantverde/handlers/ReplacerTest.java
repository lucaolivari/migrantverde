package com.deusdatsolutions.migrantverde.handlers;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ReplacerTest {
	
	@Test
	public void shouldHandleEmptyInput() {
		String input = "";
		String output = Replacer.replaceAll(input, null);
		Assert.assertEquals(input, output);
		
		String input2 = null;
		String output2 = Replacer.replaceAll(input2, null);
		Assert.assertEquals(input2, output2);
	}
	
	@Test
	public void shouldReplaceSingleValue() {
		String input = "${username}";
		Map<String, String> lookup = new HashMap<>();
		lookup.put("username", "jdavenpo");
		
		String output = Replacer.replaceAll(input, lookup);
		Assert.assertEquals("jdavenpo", output);
	}
	
	@Test
	public void shouldReplaceMultiples() {
		String input = "${username} ${password}";
		Map<String, String> lookup = new HashMap<>();
		lookup.put("username", "jdavenpo");
		lookup.put("password", "JimmyJames");
		
		String output = Replacer.replaceAll(input, lookup);
		Assert.assertEquals("jdavenpo JimmyJames", output);
	}
	
	@Test
	public void shouldReplaceNothingJustReturnTheValue() {
		String input = "Tacos are good, unless you're on Keto.";
		Map<String, String> lookup = new HashMap<>();
		lookup.put("username", "jdavenpo");
		lookup.put("password", "JimmyJames");
		
		String output = Replacer.replaceAll(input, lookup);
		Assert.assertEquals(input, output);
	}
}