import { Component, OnInit } from '@angular/core';
import {AccomodationHttpService} from '../accomodation/accomodation-http.service';
import {Accomodation} from '../Model/Accomodation';

@Component({
  selector: 'app-accomodation-detail',
  templateUrl: './accomodation-detail.component.html',
  styleUrls: ['./accomodation-detail.component.css']
})
export class AccomodationDetailComponent implements OnInit {
  accomodations: Array<Accomodation>;

  constructor(private accomodationService: AccomodationHttpService) { }

   findAll() : Array<Accomodation> {
    return this.accomodationService.findAll();
   }
  ngOnInit() {
  }

}
