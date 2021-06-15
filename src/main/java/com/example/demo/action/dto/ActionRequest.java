package com.example.demo.action.dto;

import com.example.demo.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionRequest {
    private Teacher teacher;
}
