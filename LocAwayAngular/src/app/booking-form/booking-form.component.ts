import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {NgbDate, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import {BookingHttpService} from "../booking/booking-http-service.service";
import {AccomodationHttpService} from "../accomodation/accomodation-http.service";
import {Accomodation} from "../Model/Accomodation";

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrls: ['./booking-form.component.css']
})
export class BookingFormComponent implements OnInit {
  accomodation_id: number;
  accomodation: Accomodation = null;

  //Calendrier
  hoveredDate: NgbDate;
  fromDate: NgbDate;
  toDate: NgbDate;

  asyncDataLoaded: boolean = false;
  bookedDates : Array<NgbDate> = new Array<NgbDate>();
  isDisabled = (date: NgbDate, current: {month: number}) => {
    let result: boolean = false;
    this.bookedDates.forEach( (bookedDate) => {
      if(date.equals(bookedDate)){
        result = true;
        console.log(date);
      }
    });
    return result;
  };

  constructor(private route: ActivatedRoute, private bookingService: BookingHttpService, private accomodationService: AccomodationHttpService, calendar: NgbCalendar) {
    this.fromDate = calendar.getToday();
    this.toDate = calendar.getNext(calendar.getToday(), 'd', 10);
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.accomodation_id = params['acc_id'];
      this.accomodationService.findById(this.accomodation_id).subscribe(resp => {
        this.accomodation = resp;
        this.accomodation.bookings.forEach( (booking) => {
          booking.bookedDays.forEach( (bookedDay) => {
            //le JSON retourne un string qu'il faut convertir en date
            let date = new Date(bookedDay.date);
            this.bookedDates.push(new NgbDate(date.getFullYear(), date.getMonth()+1, date.getDate()));
          });
        });
        this.asyncDataLoaded = true;
      });
    });
  }


  datesInBooking(): Array<Date>{
    let dates = new Array<Date>();
    let currentDate = this.ngbDateToDate(this.fromDate);
    console.log(currentDate);
    let stopDate = this.ngbDateToDate(this.toDate);
    console.log(stopDate);
    while (currentDate <= stopDate) {
      currentDate.setDate(currentDate.getDate() + 1);
      dates.push(new Date(currentDate));
    }
    return dates;
  }

  validateDates(): boolean{
    return true;
  }

  totalBookingPrice() : number {
    return this.datesInBooking().length * this.accomodation.defaultBasePrice;
  }

  //Fonctions pour calendrier

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

  ngbDateToDate(date: NgbDate): Date {
    if(date){
      return new Date(date.year, date.month - 1, date.day);
    }else{
      return null;
    }
  }
}
