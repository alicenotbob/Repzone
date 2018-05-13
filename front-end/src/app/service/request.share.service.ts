import {RequestModel} from "../model/request.model";
import {EventEmitter} from "@angular/core";

export class RequestShareService {

  requestModel: RequestModel = new RequestModel();

  onChange: EventEmitter<RequestModel> = new EventEmitter();

  public changeRequestModel(requestModel: RequestModel) {
    this.requestModel.customerPhone = requestModel.customerPhone;
    this.requestModel.modelId = requestModel.modelId;
    this.requestModel.brandId = requestModel.brandId;
    this.requestModel.categoryId = requestModel.categoryId;
    this.requestModel.regionId = requestModel.regionId;
    this.onChange.emit(this.requestModel);
  }
}
