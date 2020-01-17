import {Component, Input, OnInit} from '@angular/core';
import {Accomodation} from "../Model/Accomodation";
import {AccomodationHttpService} from "../accomodation/accomodation-http.service";


@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() {

  }

  ngOnInit() {
  }

}
