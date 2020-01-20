import {Component, Input, OnInit} from '@angular/core';
import {Accomodation} from "../Model/Accomodation";
import {AccomodationHttpService} from "../accomodation/accomodation-http.service";
import {findAll} from "@angular/compiler-cli/ngcc/src/utils";
import {User} from '../Model/User';


@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  connected :User = JSON.parse(localStorage.getItem("connectedUser"));

  constructor(private accomodationService: AccomodationHttpService) {
  }
  list(){
    return this.accomodationService.findAll();
  }
  ngOnInit() {
  }

}
