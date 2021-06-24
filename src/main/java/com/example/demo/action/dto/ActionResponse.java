package com.example.demo.action.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionResponse {
    private String teacherName;
    private String studentName;
}
