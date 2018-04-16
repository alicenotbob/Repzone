import { Component, OnInit } from '@angular/core';
import {Service} from "../model/service";
import {RegistrationService} from "../service/registration.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  service = new Service();

  constructor(private registrationService: RegistrationService) { }

  ngOnInit() {
  }

  public register() {
    this.registrationService.register(this.service);
  }

}
