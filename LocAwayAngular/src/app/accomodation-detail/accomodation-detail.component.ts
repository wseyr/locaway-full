import {Component, Input, OnInit} from '@angular/core';
import {AccomodationHttpService} from '../accomodation/accomodation-http.service';
import {Accomodation} from '../Model/Accomodation';
import {ActivatedRoute} from "@angular/router";
import {NgbDate} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-accomodation-detail',
  templateUrl: './accomodation-detail.component.html',
  styleUrls: ['./accomodation-detail.component.css']
})
export class AccomodationDetailComponent implements OnInit {
  accomodation_id: number;
  accomodation: Accomodation = null;

  //TODO: afficher les dates reservées dans le calendrier
  //calendrier (en cours)
  bookedDaysArray : Array<NgbDate> = new Array<NgbDate>();
  isDisabled = (date: NgbDate, current: {month: number}) => {
    date === this.bookedDaysArray[0];
  };


  constructor(private route: ActivatedRoute, private accomodationService: AccomodationHttpService) {
    this.route.params.subscribe(params => {
      console.log(params);
      this.accomodation_id = params['id'];
      this.accomodationService.findById(this.accomodation_id).subscribe(resp => {
        this.accomodation = resp;
        console.log(resp);
      });
    });
  }

  ngOnInit() {
  }

}
