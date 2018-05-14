import {EventEmitter} from "@angular/core";

export class ShareService {
  public logined: boolean = false;
  public onLoginedChange: EventEmitter<boolean> = new EventEmitter();

  changeLogined(v: boolean) {
    this.logined = v;
    this.onLoginedChange.emit(this.logined);
  }
}
