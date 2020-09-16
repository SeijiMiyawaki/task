package sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/home")
public class MainController {
	@Autowired
    private PeopleService peopleService;
    
    @GetMapping
    public String index(Model model) {
        Iterable<People> peopleList = peopleService.findAll();
        model.addAttribute("people", peopleList);
        return "index";
    }
    
    
    @Transactional(readOnly=false)
    private <insertForm> String insert(@ModelAttribute insertForm form, Model model) {
        return "/create";
    }
    
    
    @Transactional(readOnly=false)
    private <updateForm> String update(@ModelAttribute updateForm form, Model model) {
    	return "/home";
    }
    
    
    @Transactional(readOnly=false)
    private <deleteForm> String delete(@ModelAttribute deleteForm form, Model model) {
    	return "/home";
    }
}