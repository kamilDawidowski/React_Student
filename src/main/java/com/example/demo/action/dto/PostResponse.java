package com.example.demo.action.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class PostResponse {
    private String name;
    private String post;
    private LocalDate data;
    private Long postId;
}

