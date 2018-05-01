import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {RequestService} from "../../service/request.service";
import {RequestModel} from "../../model/request";
import {SelectElement} from "../../model/select.element";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  request = new RequestModel();
  regions: SelectElement[] = [];
  brands: SelectElement[] = [];
  models: SelectElement[] = [];
  categories: SelectElement[] = [];

  constructor(private router: Router,
              private requestService: RequestService) { }

  ngOnInit() {
    this.setRegions();
    this.setBrands();
    this.setCategories();
  }

  setRegions() {
    this.requestService.getRegions().subscribe(next => {
      this.regions = next;
      console.log(this.regions);
    }, err => {
      this.regions = [{id:-1, name:"NO DATA"}];
    });
  }

  setBrands() {
    this.requestService.getBrands().subscribe(next => {
      this.brands = next;
    }, err => {
      this.brands = [{id:-1, name:"NO DATA"}];
    })
  }

  setPhoneModels() {
    this.requestService.getPhoneModels(this.request.brand).subscribe(next => {
      this.models = next;
    }, err => {
      this.models = [{id:-1, name:"NO DATA"}];
    })
  }

  setCategories() {
    this.requestService.getCategories().subscribe(next => {
      this.categories = next;
    }, err => {
      this.categories = [{id:-1, name:"NO DATA"}];
    })
  }
}
