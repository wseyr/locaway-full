import { Component, OnInit } from '@angular/core';
import {Accomodation} from '../Model/Accomodation';
import {AccomodationHttpService} from './accomodation-http.service';

@Component({
  selector: 'accomodation',
  templateUrl: './accomodation.component.html',
  styleUrls: ['./accomodation.component.css']
})
export class AccomodationComponent implements OnInit {
  curentAccomodation: Accomodation=null;

  constructor(private accomodationService: AccomodationHttpService) { }

  ngOnInit() {
  }

}
