import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms'
import { User } from '../user';
import {LoginUserService} from '../login-user.service'
import{Router} from '@angular/router'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})
export class RegisterComponent implements OnInit {
  msg='';
  user:User= new User();

  userRegister(){
    console.log(this.user)
    this.loginuserservice.registerUser(this.user).subscribe(data=>{
      sessionStorage.setItem('searchSession',JSON.stringify(data))
      sessionStorage.setItem('isLoggedIn','true');
      this.router.navigate(['productsearch'])
    },error=>{this.msg="User already exists"});
    // this.msg="Please enter valid values for required fields.");
  }

  constructor(private loginuserservice:LoginUserService, private router:Router) { }

  ngOnInit() {
  }

}
