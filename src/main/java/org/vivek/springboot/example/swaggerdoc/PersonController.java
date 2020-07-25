package org.vivek.springboot.example.swaggerdoc;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@RequestMapping(path = "/person", method = RequestMethod.POST)
	public Person person(@Valid @RequestBody Person person) {
		return person;
	}

	@RequestMapping(path = "/personhttprequest", method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person personHttpRequest(HttpRequest req) {
		Person person = new Person();
		return person;
	}

	@RequestMapping(path = "/personhttpservletrequest", method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person personHttpServletRequest(HttpServletRequest req) {
		Person person = new Person();
		return person;
	}
}
