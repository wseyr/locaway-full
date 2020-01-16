import { Component, OnInit } from '@angular/core';
import {AccomodationHttpService} from '../accomodation/accomodation-http.service';

@Component({
  selector: 'app-accomodation-detail',
  templateUrl: './accomodation-detail.component.html',
  styleUrls: ['./accomodation-detail.component.css']
})
export class AccomodationDetailComponent implements OnInit {

  constructor(private accomodationService: AccomodationHttpService) { }

  ngOnInit() {
  }

}
