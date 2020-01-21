import {Component, OnInit} from '@angular/core';
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
  option: Option;
  optionId: number =175;
  options: Array<Option>;

  constructor(private accomodationService: AccomodationHttpService, private route: ActivatedRoute, private optionService: OptionHttpService) {
    this.newAccomodation = new Accomodation();

  }

  add() {


  }

  save(){
    // this.route.params.subscribe(params => {
    //   this.optionId = params['id'];
    //   this.optionHttpService.findById(this.optionId).subscribe(resp => {
    //     this.option = resp;
    //   })
    // })
  }

  list(){
    return this.optionService.findAll();
  }
  ngOnInit() {


  }

}
