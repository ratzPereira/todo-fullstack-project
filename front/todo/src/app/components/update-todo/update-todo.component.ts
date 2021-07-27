import { Component, OnInit } from "@angular/core";
import { Todo } from "../../models/todo";
import { ActivatedRoute, Router } from "@angular/router";
import { TodoService } from "../../services/todo.service";

@Component({
  selector: "app-update-todo",
  templateUrl: "./update-todo.component.html",
  styleUrls: ["./update-todo.component.css"],
})
export class UpdateTodoComponent implements OnInit {
  todo: Todo = {
    title: "",
    description: "",
    dateToFinish: new Date(),
    finished: false,
  };

  constructor(
    private router: Router,
    private service: TodoService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    //will get the id in the url and set it to our todo
    this.todo.id = this.route.snapshot.paramMap.get("id")!;
    this.findTodoById();
  }

  findTodoById(): void {
    this.service.findById(this.todo.id).subscribe((response) => {
      this.todo = response;
    });
  }

  cancelButtonHandler(): void {
    this.router.navigate([""]);
  }

  updateTodoHandler() {
    this.service.updateTodo(this.todo).subscribe(
      (response) => {
        this.service.message("Todo updated successfully");
        this.router.navigate([""]);
      },
      (error) => {
        this.service.message("Error updating your TODO");
        this.router.navigate([""]);
      }
    );
  }
}
