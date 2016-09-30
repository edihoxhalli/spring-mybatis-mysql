package com.journaldev.spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.model.Person;

import dao.DirectoryInformationMapper;
import model.DirectoryInformation;

@Transactional
@Service
public class DirectoryServiceImpl implements DirectoryService  {
	
	
	@Autowired
	private DirectoryInformationMapper diMapper;

	
	
	@Override
	@Transactional
	public List<DirectoryInformation> listDir() {
		return diMapper.selectAll();
	}
	
	@Override
	@Transactional
	public List<DirectoryInformation> filterDir(DirectoryInformation dir) {
		List<DirectoryInformation> dirs = diMapper.selectAll();
		List<DirectoryInformation> result = dirs.stream()
				.filter(d -> d.getInstnm().toLowerCase().contains(dir.getInstnm().toLowerCase()))
				.collect(Collectors.toList());
		
		return result;
	}
	/*
	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}	
	
	@Override
	@Transactional
	public List<Person> filterPersons(Person person) {
		List<Person> people = this.personDAO.listPersons();
		
		List<Person> result = people.stream() 
				.filter(p -> p.getCountry().equals(person.getCountry()))
				.collect(Collectors.toList());	
		
		return result;
	}
	
	

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}*/

}
