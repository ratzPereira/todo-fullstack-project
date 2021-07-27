import { Component, OnInit } from "@angular/core";
import { Todo } from "../../models/todo";
import { TodoService } from "../../services/todo.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-finished-todos",
  templateUrl: "./finished-todos.component.html",
  styleUrls: ["./finished-todos.component.css"],
})
export class FinishedTodosComponent implements OnInit {
  listFinished: Todo[] = [];

  constructor(private service: TodoService, private router: Router) {}

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((response) => {
      response.map((todo) => {
        if (todo.finished) {
          this.listFinished.push(todo);
        }
      });
    });
  }

  back(): void {
    this.router.navigate([""]);
  }
}
