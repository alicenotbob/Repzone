import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {RequestService} from "../../service/request.service";
import {RequestModel} from "../../model/request.model";
import {SelectElement} from "../../model/select.element";
import {ServiceModelService} from "../../service/serviceModel.service";
import {RequestShareService} from "../../service/request.share.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  requestModel = new RequestModel();
  regions: SelectElement[] = [];
  brands: SelectElement[] = [];
  models: SelectElement[] = [];
  categories: SelectElement[] = [];
  leaveReqResultMessage: string = '';
  leaveReqResultMessageClass: string = '';

  constructor(private router: Router,
              private requestService: RequestService,
              private serviceModelService: ServiceModelService,
              private requestShareService: RequestShareService) { }

  ngOnInit() {
    this.setRegions();
    this.setBrands();
    this.setCategories();
  }

  setRegions() {
    this.requestService.getRegions().subscribe(next => {
      this.regions = next;
      this.requestModel.regionId = this.regions[0].id;
    }, err => {
      this.regions = [{id:-1, name:"NO DATA"}];
    });
  }

  setBrands() {
    this.requestService.getBrands().subscribe(next => {
      this.brands = next;
      this.requestModel.brandId = this.brands[0].id;
      this.setPhoneModels();
    }, err => {
      this.brands = [{id:-1, name:"NO DATA"}];
    })
  }

  setPhoneModels() {
    this.requestService.getPhoneModels(this.requestModel.brandId).subscribe(next => {
      this.models = next;
      this.requestModel.modelId = this.models[0].id;
    }, err => {
      this.models = [{id:-1, name:"NO DATA"}];
    })
  }

  setCategories() {
    this.requestService.getCategories().subscribe(next => {
      this.categories = next;
      this.requestModel.categoryId = this.categories[0].id;

    }, err => {
      this.categories = [{id:-1, name:"NO DATA"}];
    })
  }

  leaveRequest() {
    this.clearMessage();
    this.requestService.leaveRequest(this.requestModel).subscribe(resp => {
      this.updateMessage(resp);
    }, err => {
      this.updateMessage(false);
    })
  }

  findServices() {
    this.requestShareService.changeRequestModel(this.requestModel);
    this.router.navigate(['/services']);
  }

  clearMessage() {
    this.leaveReqResultMessage = '';
    this.leaveReqResultMessageClass = '';
  }

  updateMessage(flag: boolean) {
    if(flag) {
      this.leaveReqResultMessage = 'Ваша заявка оставлена успешно.';
      this.leaveReqResultMessageClass = 'text-success';
    } else {
      this.leaveReqResultMessage = 'Ошибка сохранения заявки.';
      this.leaveReqResultMessageClass = 'text-danger';
    }
  }
}
