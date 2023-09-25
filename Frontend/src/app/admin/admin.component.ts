import { Component, OnInit } from '@angular/core';
import {LoginUserService} from '../login-user.service';
import{Router} from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.sass']
})
export class AdminComponent implements OnInit {

  adminDetail= new FormGroup({
    adminName: new FormControl(''),
    adminPass: new FormControl('')
  })

  alert= false;
  msg="Enter correct credentials!";
  constructor(private loginuserservice:LoginUserService, private router:Router) { }

  adminLogin(){
    this.loginuserservice.loginAdmin(this.adminDetail.value).subscribe(data=>{
      sessionStorage.setItem('searchSession',JSON.stringify(data));
      // sessionStorage.setItem('isALoggedIn','true');
      this.router.navigate(['admin/control'])
    },error=>{this.alert=true});
  }
  ngOnInit() {
  }

}
