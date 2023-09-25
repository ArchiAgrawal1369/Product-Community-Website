import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import {LoginUserService} from '../login-user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admin-control',
  templateUrl: './admin-control.component.html',
  styleUrls: ['./admin-control.component.sass']
})
export class AdminControlComponent implements OnInit {

  constructor(private productservice:ProductService, private router:Router) { }
  reviews:any=[];
  ngOnInit() {
    this.productservice.getReviews().subscribe((result)=>{
      console.warn(result)
      this.reviews=result
    })
  }
  approve(item){
    this.reviews.splice(item-1,1);
    this.productservice.approveReview(item).subscribe((result)=>{
      console.warn("result",result)
    });
  }
  reject(item){
    this.reviews.splice(item-1,1);
    this.productservice.rejectReview(item).subscribe((result)=>{
      console.warn("result",result)
    });
  }
  logout(){
    sessionStorage.removeItem('searchSession');
    this.router.navigate(['/'])
  }

}
