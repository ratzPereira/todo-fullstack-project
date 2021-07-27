import { Component, OnInit } from "@angular/core";
import { Todo } from "../../models/todo";

@Component({
  selector: "app-read-all",
  templateUrl: "./read-all.component.html",
  styleUrls: ["./read-all.component.css"],
})
export class ReadAllComponent implements OnInit {
  list: Todo[] = [
    {
      title: "Olá",
      dateToFinish: new Date(),
      finished: false,
    },
    {
      title: "Olá Again",
      dateToFinish: new Date(),
      finished: true,
    },
  ];

  constructor() {}

  ngOnInit(): void {}
}
