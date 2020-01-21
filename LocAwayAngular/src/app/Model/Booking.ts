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


  constructor() {
  }
}
