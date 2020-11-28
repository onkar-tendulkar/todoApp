package com.todo.todoApp;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ToDoController {

    private static List<ToDo> todos = new ArrayList<>();

    static {
        todos.add(new ToDo("Pay Credit Card Bill", "Pay using new app",new Date()));
        todos.add(new ToDo("Pay Electricity Bill", "Use Paytm",new Date()));
    }

    @GetMapping("todo")
    public List<ToDo> getTodos(@RequestParam(required = false) String name) {
        if(name==null)
            return todos;

        String nameUpper = name.toUpperCase();
        return todos.stream().filter(todo -> todo.getName().toUpperCase().contains(nameUpper)).collect(Collectors.toList());
    }

    @PostMapping("todo")
    public String upsert(@RequestBody final ToDo todoInput) {
        Optional<ToDo> tdOp = todos.stream().filter(todo -> todo.getName().equals(todoInput.getName())).findFirst();

        if(tdOp.isPresent()) {
            tdOp.get().setDetails(todoInput.getDetails());
            tdOp.get().setTime(todoInput.getTime());
        }
        else {
            todos.add(new ToDo(todoInput.getName(),todoInput.getDetails(),todoInput.getTime()));
        }
        return "SUCCESS";
    }
}
