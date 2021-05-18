package com.tiantian.sams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInformation {

    private int studentId;
    private String college;
    private String studentClass;
    private String studentNumber;
    private String name;
    private String sex;
    private String status;
    private String telephoneNumber;
    private String Birthdate;
    private String politicalAppearance;
    private String martialStatus;
    private String idNumber;
    private String nativePlace;
}
