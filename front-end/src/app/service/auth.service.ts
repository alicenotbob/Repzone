import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, Response} from '@angular/http';
import 'rxjs/add/operator/map'
import {API_URL, AUTH_TOKEN_HEADER, AUTH_TOKEN_KEY} from '../constant/API';
import {Observable} from "rxjs/Observable";
import {ServiceModelService} from "./serviceModel.service";

@Injectable()
export class AuthService {

  constructor(private http: Http,
              private serviceModelService: ServiceModelService) {}

  login(email: string, password: string): Observable<any> {
    return this.http.post(API_URL + '/login', {email, password})
      .map((response: Response) => {
        let loginResponse = response.json();
        if(loginResponse && loginResponse.token) {
          this.serviceModelService.saveService(loginResponse.service);
          localStorage.setItem(AUTH_TOKEN_KEY, loginResponse.service);
        }
      });
  }

  logout() {
    localStorage.removeItem(AUTH_TOKEN_KEY);
  }

  public jwt() {
    let authToken = localStorage.getItem(AUTH_TOKEN_KEY);
    if (authToken) {
      let headers = new Headers({AUTH_TOKEN_HEADER: authToken});
      headers.append('Content-Type', 'application/json');
      return new RequestOptions({headers: headers});
    }
  }
}
