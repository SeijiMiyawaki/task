package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    PeopleRepository repository;
    @RequestMapping("/")
        private ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        Iterable<People> list = repository.findAll();
        mav.addObject("data", list);
        return mav;
    }
    @RequestMapping("/insert")
    @Transactional(readOnly=false)
    private ModelAndView insert(@ModelAttribute("formInsert") People person, ModelAndView mav) {
        repository.saveAndFlush(person);
        return new ModelAndView("redirect:/");
    }
    @RequestMapping("/update")
    @Transactional(readOnly=false)
    private ModelAndView update(@ModelAttribute("formUpdate") People person, ModelAndView mav) {
        repository.saveAndFlush(person);
        return new ModelAndView("redirect:/");
    }
    @RequestMapping("/delete")
    @Transactional(readOnly=false)
        private ModelAndView delete(@ModelAttribute("formDelete") People person, ModelAndView mav) {
        repository.delete(person);
        return new ModelAndView("redirect:/");
    }
}