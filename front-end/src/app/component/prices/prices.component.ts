import { Component, OnInit } from '@angular/core';
import {PriceElementModel} from "../../model/price-element.model";
import {RequestService} from "../../service/request.service";
import {SelectElement} from "../../model/select.element";
import {PriceService} from "../../service/price.service";

@Component({
  selector: 'app-prices',
  templateUrl: './prices.component.html',
  styleUrls: ['./prices.component.scss']
})
export class PricesComponent implements OnInit {

  public priceElements:Array<PriceElementModel> = [];

  public brands: SelectElement[] = [];
  public models: Array<SelectElement> = [];
  public categories: SelectElement[] = [];

  constructor(private requestService: RequestService,
              private priceService: PriceService) { }

  ngOnInit() {
    this.setBrands();
    this.setCategories();
    this.getCurrentList();
  }

  setBrands() {
    this.requestService.getBrands().subscribe(next => {
      this.brands = next;
    }, err => {
      this.brands = [{id:-1, name:"NO DATA"}];
    })
  }

  setPhoneModels(priceElement: PriceElementModel) {
    if (!this.models[priceElement.brandId]) {
      this.requestService.getPhoneModels(priceElement.brandId).subscribe(next => {
        this.models[priceElement.brandId] = next;
      }, err => {
        this.models = [{id: -1, name: "NO DATA"}];
      })
    }
  }

  setCategories() {
    this.requestService.getCategories().subscribe(next => {
      this.categories = next;
    }, err => {
      this.categories = [{id:-1, name:"NO DATA"}];
    })
  }

  addPriceElement(priceElement: PriceElementModel) {
    this.priceElements.push(priceElement);
    if (!this.models[priceElement.brandId]) {
      this.setPhoneModels(priceElement);
    }
  }

  updatePriceElement(element: PriceElementModel) {
    if (element.id == 0) {
      this.priceService.savePriceElement(element).subscribe(next => {
        console.log(element);
      }, err => {
        console.log(err);
      });
    } else {
      this.priceService.updatePriceElement(element).subscribe(next => {
        console.log(element);
      }, err => {
        console.log(err);
      });
    }
  }

  deletePriceElement(element: PriceElementModel) {
    this.priceService.deletePriceElement(element).subscribe(n => {
      this.priceElements.forEach( (item, index) => {
        if(item === element) this.priceElements.splice(index,1);
      });
    }, error2 => {
      console.log(error2);
    });
  }

  getCurrentList() {
    this.priceService.getAllPriceElement().subscribe(n => {
      if (n.length > 0) {
        n.forEach(el => {
          this.addPriceElement(el);
        });
      } else {
        this.addPriceElement({id: 0, brandId: 0, modelId: 0, categoryId: 0, price: 0});
      }
    });
  }
}
