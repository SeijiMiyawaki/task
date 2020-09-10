package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class MainController {
    @Autowired
    PeopleRepository repository;
    
    @RequestMapping("/home")
        private String index(Model model) {
        Iterable<People> personlist = repository.findAll();
        model.addAttribute("person", personlist);
        return "home";
    }
    
    @RequestMapping("/insert")
    @Transactional(readOnly=false)
    private <insertForm> String insert(@ModelAttribute insertForm form) {
        return "insert";
    }
    
    @RequestMapping("/update")
    @Transactional(readOnly=false)
    private <updateForm> String update(@ModelAttribute updateForm form) {
        return "update";
    }
    
    @RequestMapping("/delete")
    @Transactional(readOnly=false)
        private  <deleteForm> String delete(@ModelAttribute deleteForm form) {
        return "delete";
    }
}