package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Student;
import com.example.demo.repository.studentinfo;


@Controller
public class StudentHandalar {

	@Autowired
	private studentinfo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "registrationjsp";
	}
	
	@RequestMapping("/addstudent")
	public String addstudent(@ModelAttribute Student stude) {
		System.out.println(stude.getId());
		System.out.println(stude.getName());
		System.out.println(stude.getCity());
		
		System.out.println(stude.getEmail());
		System.out.println(stude.getPassword());
		
		repo.save(stude);
		
		return "redirect:/get";
}
	@RequestMapping("/get")
	public String getdata(Model m)
	{
		List<Student> al=repo.findAll();
		
		m.addAttribute("e_data",al);
		
		System.out.println(al);
		return "list";
	}
	@RequestMapping("/{id}")
	public String deleteuser(@PathVariable int id)
	{
		repo.deleteById(id);
		
		return "redirect:/get";
	}
	
	@RequestMapping("/edit/{id}")
	public String editform(@PathVariable int id,Model m)
	{
		Student ob=repo.findById(id).get();
		
		m.addAttribute("std1",ob);
		return "editform";
	}
	
	@RequestMapping("/update/{id}")
	public String updatedata(@PathVariable int id, @ModelAttribute Student us)
	{
		Student user=repo.findById(id).orElse(null);
		
		if(user!=null)
		{
			user.setName(us.getName());
			user.setCity(us.getCity());
			user.setEmail(us.getEmail());
			user.setPassword(us.getPassword());
			
			
			repo.save(user);
		}
		return "redirect:/get";
	}
}
