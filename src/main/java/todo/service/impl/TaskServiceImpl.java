package todo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.dto.TaskDTO;
import todo.model.Task;
import todo.repository.TaskRepository;
import todo.service.TaskService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void saveTask(TaskDTO taskDTO, String username) {
        taskRepository.save(toTask(taskDTO,username));
    }

    @Override
    public List<TaskDTO> findTaskByUsername(String username) {
        List<Task> tasks = taskRepository.findAllByUsername(username);
        List<TaskDTO> taskDTOS = new ArrayList<>();
        if (tasks.isEmpty()){
            return taskDTOS;
        }
        tasks.forEach(task -> taskDTOS.add(toTaskDTO(task)));
        return taskDTOS;
    }

    private Task toTask(TaskDTO taskDTO, String username){
        return Task.builder().title(taskDTO.getTitle())
                .content(taskDTO.getContent())
                .username(username)
                .build();
    }

    private TaskDTO toTaskDTO(Task task){
        return TaskDTO.builder().content(task.getContent())
                .title(task.getTitle())
                .build();
    }
}
