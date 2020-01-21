import { Component } from '@angular/core';
import {User} from './Model/User';
import {HomeComponent} from './home/home.component';
import {UserHttpServiceService} from './user/user-http-service.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  connectedU : User;

  constructor(private userHttpServiceService: UserHttpServiceService) {
this.connectedU = JSON.parse(localStorage.getItem("connectedUser"));
  }

  title = 'LocAwayAngular';
  images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);
 // public connectedU : User= UserHttpServiceService.connectedUser();



}
