import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from "../service/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  error: string;

  constructor(private router: Router,
              private authService: AuthService) {
  }

  ngOnInit(): void {
  }

  login() {
    this.authService.login(this.email, this.password).subscribe(
      data => {
        this.router.navigate(['']);
      },
      err => {
        this.error = 'Invalid email or password';
      }
    );
  }
}
