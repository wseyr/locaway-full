import {Booking} from "./Booking";

export class BookedDay {
  public id: number;
  public version: number;
  public date: Date;

  public booking: Booking;


  constructor(id: number, version: number, date: Date, booking: Booking) {
    this.id = id;
    this.version = version;
    this.date = date;
    this.booking = booking;
  }
}
