package com.tobeto.spring.b;

//boilerplate => basmakalıp _ lombok
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;
    private  String name;
    private String surname;
    private int age;


}
