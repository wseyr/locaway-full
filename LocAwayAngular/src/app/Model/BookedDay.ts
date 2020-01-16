import {Booking} from "./Booking";

export class BookedDay {
  private id: number;
  private version: number;
  private date: Date;

  private booking: Booking;


  constructor(id: number, version: number, date: Date, booking: Booking) {
    this.id = id;
    this.version = version;
    this.date = date;
    this.booking = booking;
  }
}
