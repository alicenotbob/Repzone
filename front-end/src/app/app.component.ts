import {Component, OnInit} from '@angular/core';
import {AuthService} from "./service/auth.service";
import {RequestShareService} from "./service/request.share.service";
import {LocalStore} from "local-observable-store";
import {ShareService} from "./service/shareService";
import {getHover} from "@angular/language-service/src/hover";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'app';
  private logined: boolean = false;
  constructor (public authService: AuthService,
               private shareService: ShareService) {
  }

  ngOnInit(): void{
    this.shareService.onLoginedChange.subscribe(next => {
      this.logined = next;
    }, err => {
      console.log(err);
    });
  }
}
