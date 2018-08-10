package com.kennyscott.maventest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kennyscott.maventest.Foo;

@Controller
public class MyController {

	@Autowired
	private Foo foo;
	
	@Autowired
	private Gson gson;

	final static Logger LOG = Logger.getLogger(MyController.class);

	@RequestMapping(value = "/hey", method = RequestMethod.GET)
	public String handle() {
		LOG.warn("Some random warning");
		return "/html/hello.html";
	}

	@RequestMapping(value = "/heyJson", method = RequestMethod.GET)
	@ResponseBody
	public String fnarr() {
		foo.setFoo("fnarr");
		return gson.toJson(foo);
	}

}
