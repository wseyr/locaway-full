import { Component, OnInit } from '@angular/core';
import {AccomodationHttpService} from '../accomodation/accomodation-http.service';
import {Accomodation} from "../Model/Accomodation";
import {ActivatedRoute} from "@angular/router";
import {Option} from "../Model/Option";
import {OptionHttpService} from "../Option/option.service";

@Component({
  selector: 'app-accomodation-form',
  templateUrl: './accomodation-form.component.html',
  styleUrls: ['./accomodation-form.component.css']
})
export class AccomodationFormComponent implements OnInit {
  newAccomodation: Accomodation;
  options: Array<Option>;

  constructor(private accomodationService: AccomodationHttpService, private route: ActivatedRoute, private optionHttpService: OptionHttpService) {
  this.optionHttpService.findAll();
  }
  add() {
  this.newAccomodation = new Accomodation();

  }

  ngOnInit() {
  }

}
