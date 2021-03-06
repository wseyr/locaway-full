import { Component } from '@angular/core';
import {User} from './Model/User';
import {HomeComponent} from './home/home.component';
import {UserHttpServiceService} from './user/user-http-service.service';
import {NavigationEnd, Router} from '@angular/router';
import {Subscription} from "rxjs";
import {HttpEvent} from "@angular/common/http";
import {Title} from "@angular/platform-browser";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  connectedU : User;



  constructor(private router: Router, private userHttpServiceService: UserHttpServiceService, private titleService: Title) {
    this.titleService.setTitle("LocAway");

    router.events.subscribe((val) => {
      // see also
      this.connectedU = JSON.parse(localStorage.getItem("connectedUser"));
    });
  }


//   constructor(private userHttpServiceService: UserHttpServiceService) {
// this.connectedU = JSON.parse(localStorage.getItem("connectedUser"));
//   }

  title = 'LocAwayAngular';
  images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);
 // public connectedU : User= UserHttpServiceService.connectedUser();



}
