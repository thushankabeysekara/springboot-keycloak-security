package com.example.thushan.core.keycloaksecurity.model;

import lombok.*;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Book {
    private String id;
    private String title;
    private String author;

}
