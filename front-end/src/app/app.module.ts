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
import { PricesComponent } from './component/prices/prices.component';
import { ClientsComponent } from './component/clients/clients.component';
import { MainMenuComponent } from './component/main-menu/main-menu.component';
import {ShareService} from "./service/shareService";
import {PriceService} from "./service/price.service";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ServicesComponent,
    PricesComponent,
    ClientsComponent,
    MainMenuComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule.forRoot(),
  ],
  providers: [
    AuthService,
    ServiceModelService,
    RegistrationService,
    RequestService,
    RequestShareService,
    ShareService,
    PriceService
  ],
  bootstrap: [AppComponent]
})

export class AppModule {
}
