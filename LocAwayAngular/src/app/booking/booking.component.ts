import {Component, Input, OnInit} from '@angular/core';
import {Booking} from '../Model/Booking';
import {BookingHttpService} from './booking-http-service.service';
import {AccomodationHttpService} from '../accomodation/accomodation-http.service';

@Component({
  selector: 'booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  @Input() booking_id: number;
  booking: Booking = null;


  constructor(private bookingService: BookingHttpService) {

  }

  ngOnInit() {
    this.bookingService.findById(this.booking_id).subscribe(resp =>{
      this.booking = resp;

      this.booking.bookedDays.sort((bd1,bd2)=>new Date(bd1.date).getTime() - new Date(bd2.date).getTime());
      console.log(this.booking.bookedDays);
    });


  }

}
