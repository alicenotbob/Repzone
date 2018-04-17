import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from "../service/auth.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  email: string;
  password: string;
  error: string;

  constructor(private fb: FormBuilder,
              private router: Router,
              private authService: AuthService) {
  }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  login() {
    const credentials = this.loginForm.value;
    if(credentials.email && credentials.password) {
      this.authService.login(credentials.email, credentials.password).subscribe(
        data => {
          this.router.navigate(['/']);
        },
        err => {
          this.error = 'Invalid email or password';
        }
      );
    }
  }
}
