import {Injectable, OnInit} from '@angular/core';
import 'rxjs/add/operator/map'
import {API_URL, AUTH_TOKEN_KEY} from '../constant/API';
import {Observable} from "rxjs/Observable";
import {ServiceModelService} from "./serviceModel.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Service} from "../model/service";
import {ShareService} from "./shareService";

@Injectable()
export class AuthService implements OnInit{

  constructor(private http: HttpClient,
              private serviceModelService: ServiceModelService,
              private shareService: ShareService) {}

  login(email: string, password: string): Observable<any> {
    return this.http.post<Service>(API_URL + '/login', {email, password});
  }

  logout() {
    localStorage.removeItem('token');
    this.shareService.changeLogined(false);
  }

  ngOnInit(): void {
  }

  public jwt() {
    let authToken = localStorage.getItem('token');
    if (authToken) {
      let headers = new HttpHeaders({'authentication': authToken});
      headers.append('Content-Type', 'application/json');
      return headers;
    }
  }
}
