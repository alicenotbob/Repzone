import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Service} from '../model/service';
import 'rxjs/add/operator/map';
import {BehaviorSubject} from "rxjs/BehaviorSubject";


@Injectable()
export class ServiceModelService {

  private userSource = new BehaviorSubject<Service>(this.getCurrentService());
  currentUser = this.userSource.asObservable();

  constructor(private http: Http) {
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
}
