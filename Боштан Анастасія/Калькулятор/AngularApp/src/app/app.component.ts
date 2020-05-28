import { Component } from '@angular/core';
import { DataService } from './services/data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
   public value1:number;
   public value2:number;
   public result:number;

   first=this.data.getFirstData();
   second=this.data.getSecondData()
constructor(private data: DataService){

}

  calculateSuma(){
   this.result = this.value1 + this.value2;
  }

  
  calculateMultiply(){
   this.result = this.value1 * this.value2;
  }

  
  calculateDivide(){
    this.result = this.value1 / this.value2;
  }

  
  calculateMinus(){
    this.result = this.value1 - this.value2;
  }

  getResult(){
    return this.result;
  }
 
}
