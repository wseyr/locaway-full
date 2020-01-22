import {Component, Input, OnInit} from '@angular/core';
import {Accomodation} from "../Model/Accomodation";
import {AccomodationHttpService} from "../accomodation/accomodation-http.service";
import {NgbCalendar, NgbDate, NgbDateParserFormatter} from "@ng-bootstrap/ng-bootstrap";
import {map, debounceTime, distinctUntilChanged} from 'rxjs/operators';
import {Observable} from 'rxjs';

const states = ['Paris','Marseille','Lyon','Toulouse','Nice','Nantes','Strasbourg','Montpellier','Bordeaux','Lille','Rennes','Reims','Le Havre','Saint-Étienne','Toulon','Grenoble','Dijon','Angers','Villeurbanne','Saint-Denis','Le Mans','Nîmes','Aix-en-Provence','Brest','Clermont-Ferrand','Limoges','Tours','Amiens','Metz','Perpignan','Besançon','Boulogne-Billancourt','Orléans','Rouen','Mulhouse','Caen','Saint-Denis','Nancy','Saint-Paul','Argenteuil','Montreuil','Roubaix','Dunkerque','Tourcoing','Créteil','Avignon','Nanterre','Poitiers','Courbevoie','Fort-de-France','Londres','Aas','Camaran'];

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']

})

export class HomeComponent implements OnInit {

  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      map(term => term.length < 2 ? []
        : states.filter(v => v.toLowerCase().indexOf(term.toLowerCase()) > -1).slice(0, 10))
    )

  accomodations: Array<Accomodation> = null;
  accomodationsfiltrees: Array<Accomodation> = null;

  unjour: NgbDate;
  city: string ="";
  person: number = 1;
  rooms: number = 1;

  hoveredDate: NgbDate;
  fromDate: NgbDate;
  toDate: NgbDate;

  accotypes: Array<string> = new Array<string>("APPARTMENT","HOUSE","GUESTHOUSE","ALTERNATIVE");
  appartment: boolean = true;
  house: boolean = true;
  guesthouse: boolean = true;
  alternative: boolean = true;

  constructor(private accomodationService: AccomodationHttpService, private calendar: NgbCalendar, public formatter: NgbDateParserFormatter) {
    this.fromDate = calendar.getToday();
    this.toDate = calendar.getNext(calendar.getToday(), 'd', 10);

  }

  // checkbox(){
  //   this.accotypes=[];
  //   if (this.appartment) {
  //     this.accotypes.push("APPARTMENT");
  //   }
  //   if (this.house){
  //     this.accotypes.push("HOUSE");
  //   }
  //   if (this.guesthouse){
  //     this.accotypes.push("GUESTHOUSE");
  //   }
  //   if (this.alternative){
  //     this.accotypes.push("ALTERNATIVE");
  //   }
  //   this.filtre();
  // }

  list(){
    return this.accomodationService.findAll();
  }

  listByCity(city: string){
    this.person = 1;
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
    this.filtre();
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
    this.accotypes=[];
    if (this.appartment) {
      this.accotypes.push("APPARTMENT");
    }
    if (this.house){
      this.accotypes.push("HOUSE");
    }
    if (this.guesthouse){
      this.accotypes.push("GUESTHOUSE");
    }
    if (this.alternative){
      this.accotypes.push("ALTERNATIVE");
    }

    if(!this.accomodations) {
      this.accomodationsfiltrees = this.list().filter(p => (p.maxPersons >= this.person && p.numberOfRooms >= this.rooms && this.accotypes.includes(p.accomodationType)));
    }
    else{
      this.accomodationsfiltrees = this.accomodations.filter(p => (p.maxPersons >= this.person && p.numberOfRooms >= this.rooms && this.accotypes.includes(p.accomodationType)));
    }

    let selectedDates: Array<Date> = this.datesInBooking();
    this.accomodationsfiltrees = this.accomodationsfiltrees.filter(acco => this.checkDates(acco, selectedDates));

  }

  checkDates(accomodation: Accomodation, selectedDates: Array<Date>){
    let result: boolean = true;
    accomodation.bookings.forEach((booking) => {
      booking.bookedDays.forEach((bookedDay)=> {
        selectedDates.forEach((date) => {
          if(date.getTime() === new Date(bookedDay.date).getTime()){
            result = false;
            console.log("FILTRAGE PAR DATE")
          }
        });
      });
    });
    return result;
  }

  ngbDateToDate(date: NgbDate): Date {
    if(date){
      return new Date(date.year, date.month - 1, date.day);
    }else{
      return null;
    }
  }

  datesInBooking(): Array<Date>{
    let dates = new Array<Date>();

    if(!this.toDate){
      let currentDate = this.ngbDateToDate(this.fromDate);
      dates.push(new Date(currentDate));
    } else {
      let currentDate = this.ngbDateToDate(this.fromDate);
      let stopDate = this.ngbDateToDate(this.toDate);
      while (currentDate <= stopDate) {
        dates.push(new Date(currentDate));
        currentDate.setDate(currentDate.getDate() + 1);
      }
    }
    return dates;
  }

}
