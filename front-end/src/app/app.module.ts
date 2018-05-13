import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';

import {AppComponent} from './app.component';
import {LoginComponent} from './component/login/login.component';
import {RegisterComponent} from './component/register/register.component';
import {HomeComponent} from "./component/home/home.component";

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AuthService} from "./service/auth.service";
import {ServiceModelService} from "./service/serviceModel.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RegistrationService} from "./service/registration.service";
import {ServicesComponent} from "./component/services/services.component";
import {RequestService} from "./service/request.service";
import {RequestShareService} from "./service/request.share.service";
import { PricesComponent } from './prices/prices.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ServicesComponent,
    PricesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule.forRoot()
  ],
  providers: [
    AuthService,
    ServiceModelService,
    RegistrationService,
    RequestService,
    RequestShareService
  ],
  bootstrap: [AppComponent]
})

export class AppModule {
}
