package com.tobeto.spring.b;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController// Controller clası olduğunu belirtiyoruz ve o özellikleri tanımlıyor.
@RequestMapping("api/persons") // Bu controllerın kontrol edeceği alt routeları tanımlamak
public class PersonsController {

    List<Person> inMemoryList= new ArrayList<>();

    @GetMapping // api/persons

    public List<Person> get(){

        return inMemoryList;
    }

    //@GetMapping("{getById}")
    // query string, path veriable
    //path => https://localhost:8081/api/persons/1 => 1=id
    //RequestParam-query string=> https://localhost:8081/api/persons/getById?id=1
    @GetMapping("{id}")
    public Person getById(@PathVariable int id){
        //Lambda Expressions
        //Stream API
        Person person= inMemoryList
                .stream()
                .filter((p) -> p.getId() == id)
                .findFirst()
                .orElseThrow();
        return person;
    }

    @PostMapping
    public void add(@RequestBody Person person){
        inMemoryList.add(person);

    }

     @PutMapping()
    public  void update(@RequestBody Person person){
         inMemoryList.add(person);
     }

     @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        inMemoryList.remove(getById(id));

     }
}
