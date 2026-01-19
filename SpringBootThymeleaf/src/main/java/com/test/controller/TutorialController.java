package com.test.controller;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
import com.test.entity.Tutorial;
import com.test.repository.TutorialRepository;
 
@Controller
public class TutorialController {
 
	
	@Autowired
	private TutorialRepository repo;
	
	@GetMapping("/tutorials")
	public String getAllTutorials(Model model, @Param("keyword") String keyword) {
		try {
			List<Tutorial> tutorials = new ArrayList<>();
			
			if(keyword ==null) {
				repo.findAll().forEach(tutorials::add);
			}else {
				repo.findByTitleContainingIgnoreCase(keyword).forEach(tutorials::add);
				model.addAttribute("keyword", keyword);
			}
			model.addAttribute("tutorials", tutorials);
		}catch(Exception e) {
			model.addAttribute("message", e.getMessage());
		}
		
		return "tutorials";
		
	}
	
	@GetMapping("/tutorials/new")
	public String addTutorial(Model model) {
		Tutorial tutorial = new Tutorial();
		
		tutorial.setPublished(true);
		model.addAttribute("tutorial", tutorial);
		
		model.addAttribute("pageTitle", "Create new Tutorial");
		
		return "tutorial_form";
		
	}
	
	@PostMapping("/tutorials/save")
	public String saveTutorial(Tutorial tutorial, RedirectAttributes redirectAttributes) {
		try {
			repo.save(tutorial);
			redirectAttributes.addFlashAttribute("message" , "The tutorial has been saved successfully");
			
		}catch(Exception e){
			redirectAttributes.addAttribute("message", e.getMessage());
		}
		
		
		return "redirect:/tutorials";
		
	}
	
	
	@GetMapping("/tutorials/{id}")
	public String editTutorial(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
		try {
			Tutorial tutorial = new Tutorial();
			model.addAttribute("tutorial", tutorial);
			model.addAttribute("pageTitle", "Edit Tutorial(ID : " +id+")");
			return "tutorial_form";
			
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
			return "redirect:/tutorials";
		}
	}
	
	@GetMapping("/tutorials/delete/{id}")
	public String deleteTutorial(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
		try {
			repo.deleteById(id);
			redirectAttributes.addFlashAttribute("message" , "The tutorial with ID: " +id+ " has been deleted");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/tutorials";
	}
	
	@GetMapping("/tutorials/{id}/isPublished/{status}")
	public String updateTutorialPublishedStatus(@PathVariable Integer id,
			@PathVariable("status") boolean isPublished,
			Model model, RedirectAttributes redirectAttributes) {
		
		try {
			repo.updatePublishedStatus(id, isPublished);
			String status = isPublished?"published":"disabled";
			String message = "the Tutorial id = " +id+ " have been " +status;
			
			redirectAttributes.addFlashAttribute("message", message);
			
			
		}catch(Exception e){
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/tutorials";
	}
}
 
 