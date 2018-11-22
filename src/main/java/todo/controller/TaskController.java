package todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import todo.dto.TaskDTO;
import todo.model.Task;

@Controller
public class TaskController {

    @GetMapping("/task")
    public String taskForm(Model model) {
        model.addAttribute("emptyTask",new TaskDTO());
        return "task";
    }

    @PostMapping("/task")
    public String taskSubmit(@ModelAttribute Task task) {
        return "result";
    }
}
