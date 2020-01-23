import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {NgbDate, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import {BookingHttpService} from "../booking/booking-http-service.service";
import {AccomodationHttpService} from "../accomodation/accomodation-http.service";
import {Accomodation} from "../Model/Accomodation";
import {Booking} from "../Model/Booking";
import {BookeddayHttpService} from "../bookedday/bookedday-http.service";
import {BookedDay} from "../Model/BookedDay";
import {User} from "../Model/User";

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrls: ['./booking-form.component.css']
})
export class BookingFormComponent implements OnInit {
  connectedU : User = JSON.parse(localStorage.getItem("connectedUser"));
  accomodation_id: number;
  accomodation: Accomodation = null;

  newBooking: Booking = new Booking();
  numberOfPersons: number = 1;
  bookingOK: boolean = false;

  //Calendrier
  hoveredDate: NgbDate;
  fromDate: NgbDate;
  toDate: NgbDate;

  asyncDataLoaded: boolean = false;
  //dates déjà réservées
  bookedDates : Array<NgbDate> = new Array<NgbDate>();
  isDisabled = (date: NgbDate, current: {month: number}) => {
    let result: boolean = false;
    this.bookedDates.forEach( (bookedDate) => {
      if(date.equals(bookedDate)){
        result = true;
      }
    });
    return result;
  };

  constructor(private route: ActivatedRoute, private bookingService: BookingHttpService, private bookedDayService: BookeddayHttpService, private accomodationService: AccomodationHttpService, calendar: NgbCalendar) {
    this.fromDate = calendar.getToday();
    // this.toDate = calendar.getNext(calendar.getToday(), 'd', 10);
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

  validateBookingDates(): boolean{
    let result: boolean = true;
    this.datesInBooking().forEach((date) => {
      this.bookedDates.forEach((ngdate) =>{
        if(this.ngbDateToDate(ngdate).getTime() === date.getTime()){
          result = false;
        }
        });
    });
    return result;
  }

  totalBookingPrice() : number {
    let price: number = 0;
    if(this.accomodation){
      price = this.datesInBooking().length * this.accomodation.defaultBasePrice;
      price += this.numberOfPersons * this.accomodation.defaultPersonPrice * this.datesInBooking().length;
    }
    return price;
  }

  saveBooking() {
    this.newBooking.accomodation = this.accomodation;
    this.newBooking.totalPrice = this.totalBookingPrice();
    this.newBooking.user = this.connectedU;
    this.bookingService.saveNew(this.newBooking).subscribe((bookingResp) =>{
      this.newBooking = bookingResp;
      console.log(this.newBooking);
      this.bookingOK=true;

      this.datesInBooking().forEach((date: Date) =>{
        let bookedDay = new BookedDay();
        bookedDay.date = date;
        bookedDay.booking = this.newBooking;
        console.log(bookedDay);
        this.bookedDayService.save(bookedDay);
      });
    });
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
