import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-create-todo",
  templateUrl: "./create-todo.component.html",
  styleUrls: ["./create-todo.component.css"],
})
export class CreateTodoComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  cancelButtonHandler(): void {
    this.router.navigate([""]);
  }
}
