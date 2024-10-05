package com.personal.library.library_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String author;
    private Double price;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private Category category;

    public enum Category {
        FICTION,
        NON_FICTION
    }
}
