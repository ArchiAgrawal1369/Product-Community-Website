import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms'
import { User } from '../user';
import {LoginUserService} from '../login-user.service';
import{Router} from '@angular/router'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  user:User= new User();
  msg="";
  
  userLogin(){
    console.log(this.user)
    this.loginuserservice.loginUser(this.user).subscribe(data=>{

      sessionStorage.setItem('isLoggedIn','true');
      
      this.router.navigate(['productsearch'])
    },error=>{this.msg="Please enter correct credentials"});
  }
  
  constructor(private loginuserservice:LoginUserService, private router:Router) { }

  ngOnInit() {
  }

}
