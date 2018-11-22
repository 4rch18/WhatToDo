package todo.service;

import todo.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    void saveTask(TaskDTO taskDTO, String username);

    List<TaskDTO> findTaskByUsername(String username);
}
