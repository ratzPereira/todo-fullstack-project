import { Component, OnInit } from "@angular/core";
import { Todo } from "../../models/todo";
import { TodoService } from "../../services/todo.service";

@Component({
  selector: "app-read-all",
  templateUrl: "./read-all.component.html",
  styleUrls: ["./read-all.component.css"],
})
export class ReadAllComponent implements OnInit {
  list: Todo[] = [];
  finishedTodos = 0;

  constructor(private service: TodoService) {}

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((response) => {
      this.list = response;
      this.countFinishedTodos();
    });
  }

  countFinishedTodos(): void {
    for (let todo of this.list) {
      if (todo.finished) {
        this.finishedTodos++;
      }
    }
  }
}
