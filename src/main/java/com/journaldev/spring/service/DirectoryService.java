package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Person;

import model.DirectoryInformation;

public interface DirectoryService {

	List<DirectoryInformation> listDir();
	List<DirectoryInformation> filterDir(DirectoryInformation dir);
	/*public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	public List<Person> filterPersons(Person person);*/
}
