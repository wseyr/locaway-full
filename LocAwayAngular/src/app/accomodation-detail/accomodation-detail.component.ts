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

  //TODO: prendre images de la BDD
  images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);

  //TODO: afficher les dates reservées dans le calendrier
  //calendrier (en cours)
  isDisabled = (date: NgbDate, current: {month: number}) => date.day === 13;


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
