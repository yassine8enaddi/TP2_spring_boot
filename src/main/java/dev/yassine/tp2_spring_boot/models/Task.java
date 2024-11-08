package dev.yassine.tp2_spring_boot.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Description cannot be empty")
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    @NotNull(message = "Creation date cannot be null")
    private Date creationDate;

    @NotNull(message = "Due date cannot be null")
    private Date dueDate;
}
