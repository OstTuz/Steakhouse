import { Component } from '@angular/core';
import { DataService } from './services/data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'StakeHouseApp';
  url="";
 
  constructor(private data: DataService){}

  sendUrl(){
    this.url=this.data.getFirstData();
  }

}
