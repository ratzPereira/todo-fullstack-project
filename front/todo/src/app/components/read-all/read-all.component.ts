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
  listFinished: Todo[] = [];
  finishedTodos = 0;

  constructor(private service: TodoService) {}

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((response) => {
      response.map((todo) => {
        if (todo.finished) {
          this.listFinished.push(todo);
        } else {
          this.list.push(todo);
        }
      });
      this.finishedTodos = this.listFinished.length;
    });
  }
}
