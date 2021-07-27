import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Todo } from "../../models/todo";
import { TodoService } from "../../services/todo.service";

@Component({
  selector: "app-create-todo",
  templateUrl: "./create-todo.component.html",
  styleUrls: ["./create-todo.component.css"],
})
export class CreateTodoComponent implements OnInit {
  todo: Todo = {
    title: "",
    description: "",
    dateToFinish: new Date(),
    finished: false,
  };

  constructor(private router: Router, private service: TodoService) {}

  ngOnInit(): void {}

  cancelButtonHandler(): void {
    this.router.navigate([""]);
  }

  createTodoHandler() {
    this.dateFormatter();
    this.service.createTodo(this.todo).subscribe(
      (response) => {
        this.service.message("Todo Created Successfully!");
        this.router.navigate([""]);
      },
      (error) => {
        this.service.message("Failed to create TODO");
        this.router.navigate([""]);
      }
    );
  }

  dateFormatter(): void {
    let date = new Date(this.todo.dateToFinish);
    this.todo.dateToFinish = `${date.getDate()}/${
      date.getMonth() + 1
    }/${date.getFullYear()}`;
  }
}
