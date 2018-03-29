package com.company;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todocount = 3;

    static {
        todos.add(new Todo(1, "Jack", "Learn Spring MVC", new Date(), false));
        todos.add(new Todo(2, "Bob", "Learn Spring Integration", new Date(), false));
        todos.add(new Todo(3, "Jane", "Learn Spring Authentication", new Date(), false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user))
                filteredTodos.add(todo);
        }
        return filteredTodos;
    }

    public Todo addTodo(String name, String desc,
                        Date targetDate, boolean isDone) {
        Todo todo = new Todo(++todocount, name, desc, targetDate, isDone);
        todos.add(todo);
        return todo;
    }

    public Todo retrieveTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
