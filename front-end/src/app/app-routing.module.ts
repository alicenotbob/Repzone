import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import {HomeComponent} from "./component/home/home.component";
import {ServicesComponent} from "./component/services/services.component";
import {PricesComponent} from "./component/prices/prices.component";
import {ClientsComponent} from "./component/clients/clients.component";

const routes: Routes = [
  {
      path: 'login',
      component: LoginComponent
  },
  {
      path: 'register',
      component: RegisterComponent
  },
  {
      path: '',
      component: HomeComponent
  },
  {
    path: 'services',
    component: ServicesComponent
  },
  {
    path: 'prices',
    component: PricesComponent
  },
  {
    path: 'clients',
    component: ClientsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
