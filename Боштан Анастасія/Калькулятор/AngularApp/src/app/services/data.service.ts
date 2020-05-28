import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  first=4;
  second=2;

  constructor() { }

  getFirstData(){
    return this.first;
  }

  getSecondData(){
    return this.second;
  }
}
