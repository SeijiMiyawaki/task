package sample.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import sample.People;
import sample.Service.PeopleService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
    private PeopleService peopleService;
    
    @GetMapping
    public String index(Model model) {
        Iterable<People> peopleList = peopleService.findAll();
        model.addAttribute("people", peopleList);
        return ("index");
    }
    
    
    
    
    @RequestMapping("/create")
    private String create(@ModelAttribute("{createForm}")People people, Model model) {
    	model.addAttribute("people", people);
    	peopleService.save(people);
    	return "redirect:/create";
    }
    
    @RequestMapping("/update")
    private String update(@ModelAttribute("{updateForm}")People people, Model model) {
    	model.addAttribute("people", people);
    	peopleService.save(people);
    	return "redirect:/update";
    }
    
    @RequestMapping("/delete")
    private String delete(@ModelAttribute("{deleteForm}") People people, Model model) {
    	peopleService.delete(people);
    	return "redirect:/delete";
    }
}