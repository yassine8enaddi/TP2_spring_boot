package dev.yassine.tp2_spring_boot.DAO;

import dev.yassine.tp2_spring_boot.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
