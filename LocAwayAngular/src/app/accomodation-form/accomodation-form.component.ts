import {Component, OnInit} from '@angular/core';
import {AccomodationHttpService} from '../accomodation/accomodation-http.service';
import {Accomodation} from "../Model/Accomodation";
import {ActivatedRoute} from "@angular/router";
import {Option} from "../Model/Option";
import {OptionHttpService} from "../Option/option.service";
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-accomodation-form',
  templateUrl: './accomodation-form.component.html',
  styleUrls: ['./accomodation-form.component.css']
})
export class AccomodationFormComponent implements OnInit {
  newAccomodation: Accomodation = new Accomodation();
  option: Option;
  optionId: number;
  options: Array<Option>;


  constructor(private accomodationService: AccomodationHttpService, private route: ActivatedRoute, private optionService: OptionHttpService) {
    this.newAccomodation = new Accomodation();
    this.optionService.findAllObservable().subscribe(resp => {
      this.options = resp;

    }, err => console.log(err));

  }

  typesDeBiens(){
    return this.accomodationService.typesDeBiens;
  }

  save() {

    for(let option of this.options) {
      if(option.checked) {
        this.newAccomodation.options.push(option);
      }
    }

    this.accomodationService.save(this.newAccomodation);
  }


  ngOnInit() {


  }

}
