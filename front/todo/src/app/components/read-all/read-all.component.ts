import { Component, OnInit } from "@angular/core";
import { Todo } from "../../models/todo";
import { TodoService } from "../../services/todo.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-read-all",
  templateUrl: "./read-all.component.html",
  styleUrls: ["./read-all.component.css"],
})
export class ReadAllComponent implements OnInit {
  list: Todo[] = [];
  listFinished: Todo[] = [];
  finishedTodos = 0;

  constructor(private service: TodoService, private router: Router) {}

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

  deleteTodo(id: any): void {
    this.service.deleteTodo(id).subscribe((response) => {
      if (response === null) {
        this.service.message(`Task with id ${id} deleted!`);
        this.list = this.list.filter((todo) => todo.id !== id);
      }
    });
  }
  showFinished(): void {
    this.router.navigate(["finished"]);
  }

  setFinishedTodo(todoToEdit: Todo): void {
    todoToEdit.finished = true;
    this.service.updateTodo(todoToEdit).subscribe(() => {
      this.service.message(
        `Task with id ${todoToEdit.id} set as finished! Congratulations!`
      );
      this.list = this.list.filter((todo) => todo.id !== todoToEdit.id);
      this.finishedTodos++;
    });
  }

  newTodoHandler(): void {
    this.router.navigate(["create"]);
  }
}
