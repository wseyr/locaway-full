import {Booking} from "./Booking";

export class Contact {
  private id: number;
  private version: number;
  private email: string;

  private booking: Booking;


  constructor(id: number, version: number, email: string, booking: Booking) {
    this.id = id;
    this.version = version;
    this.email = email;
    this.booking = booking;
  }
}
