import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  first="Lviv steak house";
  //second=2;

  constructor() { }

  getFirstData(){
    return this.first;
  }

 
}
