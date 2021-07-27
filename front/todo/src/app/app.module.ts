import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HeaderComponent } from "./components/header/header.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

import { MatCardModule } from "@angular/material/card";
import { MatButtonModule } from "@angular/material/button";
import { MatIconModule } from "@angular/material/icon";

import { MatBadgeModule } from "@angular/material/badge";
import { MatToolbarModule } from "@angular/material/toolbar";
import { FooterComponent } from "./components/footer/footer.component";
import { ReadAllComponent } from "./components/read-all/read-all.component";
import { HttpClientModule } from "@angular/common/http";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { FinishedTodosComponent } from "./components/finished-todos/finished-todos.component";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ReadAllComponent,
    FinishedTodosComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    HttpClientModule,
    MatBadgeModule,
    MatSnackBarModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [AppComponent],
})
export class AppModule {}
