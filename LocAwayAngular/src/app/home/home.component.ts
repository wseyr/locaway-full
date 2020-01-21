import {Component, Input, OnInit} from '@angular/core';
import {Accomodation} from "../Model/Accomodation";
import {AccomodationHttpService} from "../accomodation/accomodation-http.service";
import {findAll} from "@angular/compiler-cli/ngcc/src/utils";
import {User} from '../Model/User';
import {NgbCalendar, NgbDate, NgbDateParserFormatter} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']

})

export class HomeComponent implements OnInit {


  accomodations: Array<Accomodation> = null;
  city: string ="";

  accomodationsfiltrees: Array<Accomodation> = null;
  person: number = 0;

  hoveredDate: NgbDate;
  fromDate: NgbDate;
  toDate: NgbDate;


  constructor(private accomodationService: AccomodationHttpService, private calendar: NgbCalendar, public formatter: NgbDateParserFormatter) {
    this.fromDate = calendar.getToday();
    this.toDate = calendar.getNext(calendar.getToday(), 'd', 10);

  }

  list(){
    return this.accomodationService.findAll();
  }

  listByCity(city: string){
    this.person = 0;
    this.accomodationsfiltrees =null;
    if (city!="") {
      this.accomodationService.findByCity(city).subscribe(resp => {
        this.accomodations = resp;
        console.log(this.accomodations)
      }, error => {
        console.log(error);
      });
    } else {
      this.accomodations = this.accomodationService.findAll();
    }

  }

  ngOnInit() {

    this.accomodations = this.accomodationService.findAll();
    console.log(this.accomodations)
    console.log(this.accomodationsfiltrees)
  }

  onDateSelection(date: NgbDate) {
    if (!this.fromDate && !this.toDate) {
      this.fromDate = date;
    } else if (this.fromDate && !this.toDate && date.after(this.fromDate)) {
      this.toDate = date;
    } else {
      this.toDate = null;
      this.fromDate = date;
    }
  }

  isHovered(date: NgbDate) {
    return this.fromDate && !this.toDate && this.hoveredDate && date.after(this.fromDate) && date.before(this.hoveredDate);
  }

  isInside(date: NgbDate) {
    return date.after(this.fromDate) && date.before(this.toDate);
  }

  isRange(date: NgbDate) {
    return date.equals(this.fromDate) || date.equals(this.toDate) || this.isInside(date) || this.isHovered(date);
  }

  validateInput(currentValue: NgbDate, input: string): NgbDate {
    const parsed = this.formatter.parse(input);
    return parsed && this.calendar.isValid(NgbDate.from(parsed)) ? NgbDate.from(parsed) : currentValue;
  }

  filtre() {
      if(!this.accomodations) {this.accomodationsfiltrees = this.list().filter(p => p.maxPersons >= this.person);}
      else{
        this.accomodationsfiltrees = this.accomodations.filter(p => p.maxPersons >= this.person);
      }
    }

}
