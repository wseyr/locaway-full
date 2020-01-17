import {Component, Input, OnInit} from '@angular/core';
import {Accomodation} from '../Model/Accomodation';
import {AccomodationHttpService} from './accomodation-http.service';

@Component({
  selector: 'accomodation',
  templateUrl: './accomodation.component.html',
  styleUrls: ['./accomodation.component.css']
})
export class AccomodationComponent implements OnInit {
  @Input() accomodation_id: number;
  accomodation: Accomodation = null;

  constructor(private accomodationService: AccomodationHttpService) {

  }

  ngOnInit() {
    this.accomodationService.findById(this.accomodation_id).subscribe(resp => {
      this.accomodation = resp;
    });
  }

}
