import {Injectable} from '@angular/core';
import {Service} from '../model/service';
import 'rxjs/add/operator/map';
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {HttpClient} from "@angular/common/http";
import {RequestModel} from "../model/request.model";
import {Observable} from "rxjs/Observable";
import {API_URL} from "../constant/API";


@Injectable()
export class ServiceModelService {

  private userSource = new BehaviorSubject<Service>(this.getCurrentService());
  currentUser = this.userSource.asObservable();

  constructor(private http: HttpClient) {
  }

  downloadUserFromLocalStorage() {
    this.setService(this.getCurrentService());
  }

  setService(service: Service) {
    this.userSource.next(service)
  }

  getCurrentService(): Service {
    if (typeof localStorage !== 'undefined') {
      return JSON.parse(localStorage.getItem('currentUser'))
    }
  }

  saveService(service: Service) {
    if (service) {
      localStorage.setItem('currentUser', JSON.stringify(service));
    }
  }

  removeService() {
    localStorage.removeItem('currentUser');
  }

  findServices(request: RequestModel): Observable<any> {
    return this.http.post(API_URL + "/searchServices", request);
  }
}
