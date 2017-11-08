package com.srai.controller;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.srai.model.Person;

@Component
public class PersonResourceAssembler extends ResourceAssemblerSupport<Person, PersonResource> {
	public PersonResourceAssembler() {
		super(PersonController.class, PersonResource.class);
	}

	@Override
	public PersonResource toResource(Person entity) {
		PersonResource resource = createResourceWithId(entity.getId(), entity);
		BeanUtils.copyProperties(entity, resource);
		return resource;
	}
}

class PersonResource extends ResourceSupport {
	private String firstName;
	private String lastName;
	private Date createdAt;
	private Date updatedAt;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}