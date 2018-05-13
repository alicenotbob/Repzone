import { Component, OnInit } from '@angular/core';
import {PriceElementModel} from "../model/price-element.model";
import {RequestService} from "../service/request.service";

@Component({
  selector: 'app-prices',
  templateUrl: './prices.component.html',
  styleUrls: ['./prices.component.scss']
})
export class PricesComponent implements OnInit {

  public priceElements:Array<PriceElementModel> = [];

  constructor(private requestService: RequestService) { }

  ngOnInit() {
  }

  addPriceElement() {
    this.priceElements.push({id: 123,
    regionId: 123,
    brandId: 123,
    modelId: 22,
    categoryId: 44,
    cost: 77});
  }

  updatePriceElement(element: PriceElementModel) {
    //ToDo: request to update in db
  }

  deletePriceElement(element: PriceElementModel) {
    //ToDo: request to delete from db
    this.priceElements.forEach( (item, index) => {
      if(item === element) this.priceElements.splice(index,1);
    });
  }

}
