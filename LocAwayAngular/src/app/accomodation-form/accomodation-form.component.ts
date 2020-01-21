import {Component, OnInit} from '@angular/core';
import {AccomodationHttpService} from '../accomodation/accomodation-http.service';
import {Accomodation} from "../Model/Accomodation";
import {ActivatedRoute} from "@angular/router";
import {Option} from "../Model/Option";
import {OptionHttpService} from "../Option/option.service";
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Subscription} from "rxjs";
import {HttpEvent} from "@angular/common/http";

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

  accept = '*'
  files:File[] = []
  progress:number
  //url = 'https://evening-anchorage-3159.herokuapp.com/api/'
  url = 'https://jquery-file-upload.appspot.com/'
  hasBaseDropZoneOver:boolean = false
  httpEmitter:Subscription
  httpEvent:HttpEvent<{}>
  lastFileAt:Date
  sendableFormData:FormData//populated via ngfFormData directive
  dragFiles:any
  validComboDrag:any
  lastInvalids:any
  fileDropDisabled:any
  maxSize:any
  baseDropValid:any


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
  getDate(){
    return new Date()
  }
  ngOnInit() {


  }

}
