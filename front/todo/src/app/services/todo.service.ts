import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Todo } from "../models/todo";
import { environment } from "../../environments/environment";

@Injectable({
  providedIn: "root",
})
export class TodoService {
  url = environment.baseUrl;

  constructor(private http: HttpClient) {}

  findAll(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.url);
  }
}
