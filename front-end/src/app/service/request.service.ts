import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {API_URL} from "../constant/API";
import {RequestModel} from "../model/request.model";

@Injectable()
export class RequestService {

  constructor(private http: HttpClient) {
  }

  getRegions(): Observable<any> {
    return this.http.get(API_URL + "/getRegions");
  }

  getBrands(): Observable<any> {
    return this.http.get(API_URL + "/getBrands");
  }

  getPhoneModels(brandId: number): Observable<any> {
    return this.http.get(API_URL + "/getModels/" + brandId);
  }

  getCategories(): Observable<any> {
    return this.http.get(API_URL + "/getCategories");
  }

  leaveRequest(request: RequestModel): Observable<any> {
    return this.http.post(API_URL + "/leaveRequest", request);
  }
}
