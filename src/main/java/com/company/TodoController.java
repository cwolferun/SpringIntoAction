package com.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{name}/todos")
    public List<Todo> retrieveTodos(@PathVariable String name){
        return todoService.retrieveTodos(name);
    }

    @GetMapping(path = "/users/{name}/todos/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    public Resource<Todo> retrieveTodo(@PathVariable String name, @PathVariable int id){
        Todo todo = todoService.retrieveTodo(id);
        if(todo==null){
            throw new RuntimeException();
        }
        Resource<Todo> todoResource = new Resource<>(todo);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveTodos(name));
        todoResource.add(linkTo.withRel("parent"));

        return  todoResource;
    }

    @GetMapping(path = "/users")
    public String retrieveWithParams(@RequestParam(value = "name", defaultValue = "World")String passedIn){
        return  "Your param was " + passedIn;
    }
    @PostMapping("/users/{name}/todos")
    ResponseEntity<?> add(@PathVariable String name, @RequestBody Todo todo){
        Todo createdTodo = todoService.addTodo(name, todo.getDesc(),todo.getTargetDate(),todo.isDone());

        if(todo==null){
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(location).build();
    }



}
