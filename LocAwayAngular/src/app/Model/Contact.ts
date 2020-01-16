import {Booking} from "./Booking";

export class Contact {
  public id: number;
  public version: number;
  public email: string;

  public booking: Booking;


  constructor(id: number, version: number, email: string, booking: Booking) {
    this.id = id;
    this.version = version;
    this.email = email;
    this.booking = booking;
  }
}
