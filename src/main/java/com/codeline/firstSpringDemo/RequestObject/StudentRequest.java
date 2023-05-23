package com.codeline.firstSpringDemo.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class StudentRequest {
    String FirstName;
    String LastName;
    String rollNumber;
}
