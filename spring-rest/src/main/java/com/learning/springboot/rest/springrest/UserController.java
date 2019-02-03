package com.learning.springboot.rest.springrest;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class UserController {
	@Qualifier(value = "messageSource")
	@Autowired
	private MessageSource messageSource;
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public HelloWorld getMessage() {
		return new HelloWorld("Hello World");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	/*
	 * Implementation of HATEOS
	 * 
	 * Hatoes is used to provide links of additional services
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			"application/json" })
	public Resource<User> getUser(@PathVariable Integer id) {
		Resource<User> resource = new Resource<User>(userService.getUser(id));
		ControllerLinkBuilder linkto = linkTo(methodOn(this.getClass()).getUsers());
		resource.add(linkto.withRel("users"));
		return resource;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/users/{id}/{name}")
	public void save(@PathVariable Integer id, @PathVariable String name) {
		userService.save(id, name);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/internationalization")
	public String getWish(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning", null, locale);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/filter/users")
	public MappingJacksonValue getUsersmapping() {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("userFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(userService.getUsers());
		mapping.setFilters(filterProvider);
		return mapping;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/users/filter/{id}")
	public MappingJacksonValue getWishing(@RequestHeader(name = "Accept-Language", required = false) Locale locale,
			@PathVariable Integer id) {
		User user = userService.getUser(id);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("userFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(user);
		mapping.setFilters(filterProvider);
		return mapping;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/users/jpa/{id}")
	public User getUserByIdJPA(@PathVariable Integer id) {
		return userService.getbyId(id);
	}
}
