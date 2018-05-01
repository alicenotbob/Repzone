import { Component, OnInit } from '@angular/core';
import {Service} from "../../model/service";
import {RegistrationService} from "../../service/registration.service";
import {HttpErrorResponse} from "@angular/common/http";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  private registrationForm: FormGroup;
  private service = new Service();
  private errorMessage: string;
  private emailExistMessage: string;

  constructor(private fb: FormBuilder,
              private router: Router,
              private registrationService: RegistrationService) {

  }

  ngOnInit() {
    this.registrationForm = this.fb.group({
      email : [this.service.email, [
        Validators.required,
        Validators.email
      ]],
      password : [this.service.password, [
        Validators.required
      ]],
      serviceName : [this.service.serviceName, [
        Validators.required
      ]],
      serviceDescription : [this.service.serviceDescription,],
      serviceWorkingTime : [this.service.serviceWorkingTime, [
        Validators.required
      ]],
      servicePhones : [this.service.servicePhones, [
        Validators.pattern('\\\+\d{12}')
      ]],
      warranty : [this.service.warranty],
      officialService : [this.service.officialService],
      courierAvailability : [this.service.courierAvailability],
      legalEntityService : [this.service.legalEntityService]
    });
  }

  public register() {
    this.registrationService.register(this.service).subscribe(
      res => {
        if(res.data === 'EMAIL_ALREADY_EXIST') {
          this.emailExistMessage = 'Such email already exist';
        }
      },
      (err: HttpErrorResponse) => {
        this.errorMessage = err.message;
      }
    );
  }

}
