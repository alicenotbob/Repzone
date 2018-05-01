import {Injectable} from "@angular/core";
import {Service} from "../model/service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {API_URL} from "../constant/API";

@Injectable()
export class RegistrationService {

  constructor(private httpClient: HttpClient) {

  }

  public register(service: Service): Observable<any> {
      return this.httpClient.post(API_URL + "/register", service);
  }
}
