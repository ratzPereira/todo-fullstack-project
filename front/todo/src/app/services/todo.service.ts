import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Todo } from "../models/todo";
import { environment } from "../../environments/environment";
import { MatSnackBar } from "@angular/material/snack-bar";

@Injectable({
  providedIn: "root",
})
export class TodoService {
  url = environment.baseUrl;

  constructor(private http: HttpClient, private snack: MatSnackBar) {}

  findAll(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.url);
  }

  deleteTodo(id: any): Observable<void> {
    const url = `${this.url}/${id}`;
    return this.http.delete<void>(url);
  }

  message(msg: String): void {
    this.snack.open(`${msg}`, "Ok", {
      horizontalPosition: "end",
      verticalPosition: "top",
      duration: 4000,
    });
  }

  updateTodo(todo: Todo): Observable<Todo> {
    const url = `${this.url}/${todo.id}`;
    return this.http.put<Todo>(url, todo);
  }

  createTodo(todo: Todo): Observable<Todo> {
    return this.http.post<Todo>(this.url, todo);
  }
}
