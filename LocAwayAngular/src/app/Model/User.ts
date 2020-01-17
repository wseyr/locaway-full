import {Review} from './Review';
import {Accomodation} from "./Accomodation";
import {Bookmark} from "./Bookmark";
import {Booking} from "./Booking";

export class User {

  public id: number;
  public version: number =0;
  public isAdmin: boolean;
  public email: string;
  public password: string;
  public phoneNumber: string;
  public firstName: string;
  public lastName: string;
  public reviews: Array<Review>;
  public bookmarks: Array<Bookmark>;
  public bookings: Array<Booking>;
  public accomodations: Array<Accomodation>;


  constructor(id?: number, version?: number, isAdmin?: boolean, email?: string, password?: string, phoneNumber?: string, firstName?: string, lastName?: string, reviews?: Array<Review>, bookmarks?: Array<Bookmark>, bookings?: Array<Booking>, accomodations?: Array<Accomodation>) {
    this.id = id;
    this.version = version;
    this.isAdmin = isAdmin;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.reviews = reviews;
    this.bookmarks = bookmarks;
    this.bookings = bookings;
    this.accomodations = accomodations;
  }
}

