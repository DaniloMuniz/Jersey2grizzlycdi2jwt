/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.model;

import java.time.LocalDate;
import lombok.Data;

/**
 *
 * @author washington-muniz
 */
@Data
public class Student {

    private int id;
    private String name;
    private LocalDate birthday;
    private School school;

    /**
     * method get safe school id.
     *
     * @return return -1 if school null, else id int.
     */
    public int getSchoolId() {
        return (this.school != null) ? this.school.getId() : -1;
    }

}
