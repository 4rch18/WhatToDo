package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    @GetMapping("/task")
    public String taskForm(Model model) {
        model.addAttribute("emptyTask",new toDoTask());
        return "task";
    }

    @PostMapping("/task")
    public String taskSubmit(@ModelAttribute toDoTask task) {
        return "result";
    }
}
