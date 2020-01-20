import {Component, Input, OnInit} from '@angular/core';
import {Accomodation} from "../Model/Accomodation";
import {AccomodationHttpService} from "../accomodation/accomodation-http.service";
import {findAll} from "@angular/compiler-cli/ngcc/src/utils";

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  accomodations: Array<Accomodation> = new Array<Accomodation>();
  city: string =null;
  constructor(private accomodationService: AccomodationHttpService) {
  }

  list(){
    return this.accomodationService.findAll();
  }

  listByCity(city: string){
    if (city!="") {
      this.accomodationService.findByCity(city).subscribe(resp => {
        this.accomodations = resp;
        console.log(this.accomodations)
      }, error => {
        console.log(error);
      });
    } else {
      return this.accomodations = this.accomodationService.findAll();
    }
  }

  ngOnInit() {
  }

}
