import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {AuthService} from "./service/auth.service";
import {ServiceModelService} from "./service/serviceModel.service";
import {HttpModule} from "@angular/http";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    NgbModule.forRoot()
  ],
  providers: [
    AuthService,
    ServiceModelService
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
