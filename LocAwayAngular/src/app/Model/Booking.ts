import {User} from "./User";
import {Accomodation} from "./Accomodation";
import {Contact} from "./Contact";
import {BookedDay} from "./BookedDay";

export class Booking {
  private id: number;
  private version: number;
  private isValidated: boolean;
  private isCancelled: boolean;
  private totalPrice: number;


  private user: User;
  private accomodation: Accomodation;
  private bookedDays: Array<BookedDay>;
  private contacts: Array<Contact>;


  constructor(id: number, version: number, isValidated: boolean, isCancelled: boolean, totalPrice: number, user: User, accomodation: Accomodation, bookedDays: Array<BookedDay>, contacts: Array<Contact>) {
    this.id = id;
    this.version = version;
    this.isValidated = isValidated;
    this.isCancelled = isCancelled;
    this.totalPrice = totalPrice;
    this.user = user;
    this.accomodation = accomodation;
    this.bookedDays = bookedDays;
    this.contacts = contacts;
  }
}
