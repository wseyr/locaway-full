import {User} from "./User";
import {Accomodation} from "./Accomodation";
import {Contact} from "./Contact";
import {BookedDay} from "./BookedDay";

export class Booking {
  public id: number;
  public version: number;
  public isValidated: boolean;
  public isCancelled: boolean;
  public totalPrice: number;


  public user: User;
  public accomodation: Accomodation;
  public bookedDays: Array<BookedDay>;
  public contacts: Array<Contact>;


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
