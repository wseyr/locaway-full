import {Component, OnInit} from '@angular/core';
import {AccomodationHttpService} from '../accomodation/accomodation-http.service';
import {Accomodation} from "../Model/Accomodation";
import {ActivatedRoute, Router} from "@angular/router";
import {Option} from "../Model/Option";
import {OptionHttpService} from "../Option/option.service";
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Subscription} from "rxjs";
import {HttpClient, HttpEvent} from "@angular/common/http";
import {FileHttpService} from "../fileUpload/file-http.service";
import {PhotoHttpService} from "../photo/photo-http.service";
import {Photo} from "../Model/Photo";
import {User} from "../Model/User";

@Component({
  selector: 'app-accomodation-form',
  templateUrl: './accomodation-form.component.html',
  styleUrls: ['./accomodation-form.component.css']
})
export class AccomodationFormComponent implements OnInit {
  connectedU : User = JSON.parse(localStorage.getItem("connectedUser"));

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


  constructor(private accomodationService: AccomodationHttpService, private route: ActivatedRoute, private optionService: OptionHttpService, private fileService: FileHttpService, private photoService: PhotoHttpService, private router: Router) {
    this.newAccomodation = new Accomodation();
    this.newAccomodation.defaultPersonPrice = 0;
    this.newAccomodation.defaultBasePrice = 0;
    this.newAccomodation.numberOfRooms = 1;
    this.newAccomodation.maxPersons = 1;
    this.newAccomodation.accomodationType = this.accomodationService.typesDeBiens[0];
    this.optionService.findAllObservable().subscribe(resp => {
      this.options = resp;

    }, err => console.log(err));

  }

  typesDeBiens(){
    return this.accomodationService.typesDeBiens;
  }

  valide:boolean;
  verifname: boolean =true;
  veriftype: boolean=true;
  verifnum: boolean=true;
  verifrue: boolean=true;
  verifpostcode: boolean=true;
  verifville: boolean=true;
  verifpays: boolean=true;
  verifnbchambre: boolean=true;
  verifnbpersmax: boolean=true;
  verifprix: boolean=true;
  save() {
    this.valide = false;
    this.verifname = true;
    this.veriftype= true;
    this.verifnum= true;
    this.verifrue= true;
    this.verifpostcode= true;
    this.verifville= true;
    this.verifpays= true;
    this.verifnbchambre= true;
    this.verifnbpersmax= true;
    this.verifprix= true;
    if (this.newAccomodation.name && this.newAccomodation.number && this.newAccomodation.accomodationType && this.newAccomodation.street && this.newAccomodation.city && this.newAccomodation.country && this.newAccomodation.numberOfRooms>=0 && this.newAccomodation.maxPersons>=0 && this.newAccomodation.defaultBasePrice>=0) {
      for (let option of this.options) {
        if (option.checked) {
          this.newAccomodation.options.push(option);
        }
      }
      this.newAccomodation.user = this.connectedU;
      this.accomodationService.saveObservable(this.newAccomodation).subscribe((accomResp) => {

        //variable pour rediriger après l'upload de la dernière photo
        let nbPhoto: number = 0;
        if(this.files.length == 0){
          this.router.navigate(["accomodation-detail", accomResp.id]);;
        }
        this.files.forEach((file) => {
          this.fileService.upload(file).subscribe((resp) => {
            let newPhoto: Photo = new Photo();
            newPhoto.accomodation = accomResp;
            newPhoto.path = resp.fileDownloadUri;
            this.photoService.saveObservable(newPhoto).subscribe((resp) => {
              nbPhoto++;
              if (nbPhoto == this.files.length) {
                this.router.navigate(["accomodation-detail", accomResp.id]);
              }
            });

          });
        });
      });
    }else if (!this.newAccomodation.name){
      this.verifname =false;
      this.valide =true;
    }else if(!this.newAccomodation.accomodationType){
      this.veriftype = false;
      this.valide =true;

    }else if(!this.newAccomodation.number){
      this.verifnum = false;
      this.valide =true;

    }else if(!this.newAccomodation.street){
      this.verifrue = false;
      this.valide =true;

    }else if (!this.newAccomodation.postcode) {
      this.verifpostcode = false;

      this.valide =true;

    }else if(!this.newAccomodation.city){
      this.verifville = false;
      this.valide =true;

    }else if(!this.newAccomodation.country){
      this.verifpays = false;
      this.valide =true;

    }else if(this.newAccomodation.numberOfRooms<0){
      this.verifnbchambre = false;
      this.valide =true;

    }else if(this.newAccomodation.maxPersons<0){
      this.verifnbpersmax = false;
      this.valide =true;

    }else if(this.newAccomodation.defaultBasePrice<0){
      console.log(this.newAccomodation.defaultBasePrice)
      this.verifprix = false;
      this.valide =true;
    }

  }
  getDate(){
    return new Date()
  }
  ngOnInit() {

  }

  textForAccomtype(typedebien: string): string{
    if(typedebien == "HOUSE"){
      return "Maison";
    } else if(typedebien == "APPARTMENT"){
      return "Appartement";
    }else if(typedebien == "GUESTHOUSE"){
      return "Maison d'hôtes";
    }else if(typedebien == "ALTERNATIVE"){
      return "Alternatif";
    }else{
      return "défaut";
    }
  }
}
