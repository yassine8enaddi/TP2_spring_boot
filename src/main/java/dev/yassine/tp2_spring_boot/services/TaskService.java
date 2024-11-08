package dev.yassine.tp2_spring_boot.services;

import dev.yassine.tp2_spring_boot.DAO.TaskRepository;
import dev.yassine.tp2_spring_boot.models.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setCreationDate(updatedTask.getCreationDate());
            existingTask.setDueDate(updatedTask.getDueDate());
            return taskRepository.save(existingTask);
        } else {
            return null;
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
