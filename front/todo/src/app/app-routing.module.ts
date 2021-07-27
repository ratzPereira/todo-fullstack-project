import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ReadAllComponent } from "./components/read-all/read-all.component";
import { FinishedTodosComponent } from "./components/finished-todos/finished-todos.component";

const routes: Routes = [
  {
    path: "",
    component: ReadAllComponent,
  },
  {
    path: "finished",
    component: FinishedTodosComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
