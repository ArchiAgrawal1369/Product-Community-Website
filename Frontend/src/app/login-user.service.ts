import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginUserService {
  private loginUrl="http://localhost:8086/login";
  private registerUrl="http://localhost:8086/register";
  private countProd="http://localhost:8086/count-products";
  private countUser="http://localhost:8086/count-users";
  private countReview="http://localhost:8086/count-reviews";
  private admin="http://localhost:8086/admin";

  constructor(private httpClient:HttpClient, private router:Router ) { }

  loginAdmin(data){
    return this.httpClient.post(`${this.admin}`,data);
  }

  loginUser(user: User){
    return this.httpClient.post(`${this.loginUrl}`,user);
  }

  registerUser(user: User){
    console.log(user)
    return this.httpClient.post(`${this.registerUrl}`,user);
  }

  countProducts(){
    return this.httpClient.get(this.countProd);
  }

  countUsers(){
    return this.httpClient.get(this.countUser);
  }

  countReviews(){
    return this.httpClient.get(this.countReview);
  }
}
