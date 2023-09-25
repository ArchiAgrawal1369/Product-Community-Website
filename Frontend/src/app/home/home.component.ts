import { Component, OnInit } from '@angular/core';
import {LoginUserService} from '../login-user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {
  numberOfProducts;
  numberofUsers;
  numberofReviews;
  constructor(private loginuserservice:LoginUserService) { }

  ngOnInit() {
    this.loginuserservice.countProducts().subscribe((result)=>{
      this.numberOfProducts=result
    });
    this.loginuserservice.countUsers().subscribe((result)=>{
      this.numberofUsers=result
    });
    this.loginuserservice.countReviews().subscribe((result)=>{
      this.numberofReviews=result
    });
  }
 

}
