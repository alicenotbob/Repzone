import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ServiceModelService} from "../../service/serviceModel.service";
import {Service} from "../../model/service";
import {RequestModel} from "../../model/request.model";
import {RequestShareService} from "../../service/request.share.service";
import {RequestService} from "../../service/request.service";
import {SelectElement} from "../../model/select.element";

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.scss']
})
export class ServicesComponent implements OnInit {

  serviceModels: Service[] = [];
  requestModel = new RequestModel();
  regions: SelectElement[] = [];
  brands: SelectElement[] = [];
  models: SelectElement[] = [];
  categories: SelectElement[] = [];

  constructor(private route: ActivatedRoute,
              private serviceModelService: ServiceModelService,
              private requestShareService: RequestShareService,
              private requestService: RequestService) {

  }

  ngOnInit() {
    this.setRegions();
    this.setBrands();
    this.setCategories();
    this.requestShareService.onChange.subscribe( requestModel => {
      this.serviceModelService.findServices(requestModel).subscribe(next => {
        this.serviceModels = next;
      }, err => {
        console.log(err);
      });
    });
  }

  findServices() {

  }

  setRegions() {
    this.requestService.getRegions().subscribe(next => {
      this.regions = next;
      this.requestModel.regionId = this.requestShareService.requestModel.regionId;
      if (!this.requestShareService.requestModel.regionId) {
        this.requestModel.regionId = this.regions[0].id;
      }
    }, err => {
      this.regions = [{id:-1, name:"NO DATA"}];
    });
  }

  setBrands() {
    this.requestService.getBrands().subscribe(next => {
      this.brands = next;
      this.requestModel.brandId = this.requestShareService.requestModel.brandId;
      this.setPhoneModels();
      if (!this.requestShareService.requestModel.brandId) {
        this.requestModel.brandId = this.brands[0].id;
        this.setPhoneModels();
      }
    }, err => {
      this.brands = [{id:-1, name:"NO DATA"}];
    })
  }

  setPhoneModels() {
    this.requestService.getPhoneModels(this.requestModel.brandId).subscribe(next => {
      this.models = next;
      this.requestModel.modelId = this.requestShareService.requestModel.modelId;
      if (!this.requestShareService.requestModel.modelId) {
        this.requestModel.modelId = this.models[0].id;
      }
      }, err => {
      this.models = [{id:-1, name:"NO DATA"}];
    })
  }

  setCategories() {
    this.requestService.getCategories().subscribe(next => {
      this.categories = next;
      this.requestModel.categoryId = this.requestShareService.requestModel.categoryId;
      if (!this.requestShareService.requestModel.categoryId) {
        this.requestModel.categoryId = this.categories[0].id;
      }
    }, err => {
      this.categories = [{id:-1, name:"NO DATA"}];
    })
  }

}
