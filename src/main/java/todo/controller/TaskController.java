package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import todo.dto.TaskDTO;
import todo.service.TaskService;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public String taskForm(Model model) {
        List<TaskDTO> taskDTOS = taskService.findTaskByUsername("user");
        model.addAttribute("emptyTask",new TaskDTO());
        model.addAttribute("tasks", taskDTOS);
        return "task";
    }

    @PostMapping("/task")
    public String taskSubmit(@ModelAttribute TaskDTO taskDTO) {
        taskService.saveTask(taskDTO,"user");

        /**
         * using only 'task' won't work
         * https://www.logicbig.com/examples/spring-mvc/redirect/spring-mvc-redirect-post-to-get.html
         */
        return "redirect:/task";

    }
}
