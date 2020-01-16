import {Review} from './Review';

export class User {

  private id: number;
  private version: number =0;
  private isAdmin: boolean;
  private email: string;
  private password: string;
  private phoneNumber: string;
  private firstName: string;
  private lastName: string;
  private reviews: Array<Review>;
  private bookmarks: Array<Bookmark>;
  private bookings: Array<Booking>;
  private accomodations: Array<Accomodation>;


  constructor(isAdmin?: boolean, email?: string, password?: string, phoneNumber?: string, firstName?: string, lastName?: string,
              reviews?: Array<Review>, bookmarks?: Array<Bookmark>, bookings?: Array<Booking>, accomodations?: Array<Accomodation>) {
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

