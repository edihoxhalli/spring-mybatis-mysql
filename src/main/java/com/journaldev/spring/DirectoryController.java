package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.DirectoryService;

import model.DirectoryInformation;

@Controller
public class DirectoryController {
	
	@Autowired
	private DirectoryService directoryService;
	 
	
	@RequestMapping(value={"/", "directory"}, method = RequestMethod.GET)
	public String listDirectory(Model model, @ModelAttribute("directory") DirectoryInformation directory) {
		model.addAttribute("directory", new DirectoryInformation());
		model.addAttribute("listDirectory", this.directoryService.listDir());
		return "directory";
	}
	
	@RequestMapping(value="/directory/filter", method = RequestMethod.POST)
	public String filterDirectory(Model model, @ModelAttribute("directory") DirectoryInformation directory) {
		model.addAttribute("directory", new DirectoryInformation());
		model.addAttribute("listDirectory", this.directoryService.filterDir(directory));
		return "directory";
	}
	
	/*//Filter person
	@RequestMapping(value= "/person/filter", method = RequestMethod.POST)
	public String filter(Model model, @ModelAttribute("person") Person person){
		System.out.println("asdfasdf");
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.filterPersons(person));
		return "person";
		
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }*/
	
}
