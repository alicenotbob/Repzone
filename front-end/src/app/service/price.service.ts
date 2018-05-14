
import {Injectable, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {PriceElementModel} from "../model/price-element.model";
import {HttpClient} from "@angular/common/http";
import {LoginComponent} from "../component/login/login.component";
import {AuthService} from "./auth.service";
import {Observable} from "rxjs/Observable";
import {API_URL} from "../constant/API";

@Injectable()
export class PriceService implements OnInit {

  constructor(private http: HttpClient,
              private authService: AuthService) {
  }

  ngOnInit(): void {
  }

  public savePriceElement(pe: PriceElementModel): Observable<any> {
    return this.http.post(API_URL + '/savePriceElement', pe, {headers: this.authService.jwt()});
  }

  public updatePriceElement(pe: PriceElementModel): Observable<any> {
    return this.http.post(API_URL + '/updatePriceElement', pe, {headers: this.authService.jwt()});
  }

  public deletePriceElement(pe: PriceElementModel): Observable<any> {
    return this.http.post(API_URL + '/deletePriceElement', pe, {headers: this.authService.jwt()});
  }

  public getAllPriceElement(): Observable<any> {
    return this.http.get(API_URL + '/getPriceElements', {headers: this.authService.jwt()});
  }
}
