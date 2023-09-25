import { Component, OnInit } from '@angular/core';
import{FormGroup, FormControl} from '@angular/forms';
import{Router} from '@angular/router';
import {ProductService } from '../product.service'

@Component({
  selector: 'app-raise-review',
  templateUrl: './raise-review.component.html',
  styleUrls: ['./raise-review.component.sass']
})
export class RaiseReviewComponent implements OnInit {
  productDetail= new FormGroup({
    productCode: new FormControl(),
    productName: new FormControl(),
    productBrand: new FormControl(),
    productColor:new FormControl(),
    productPrice: new FormControl()
  })

  constructor(private route:Router, private prodService: ProductService) { }

  msg = "Error: Product Code already exists!";
  alert = false;

  addProductDetail(){
    this.prodService.addProduct(this.productDetail.value).subscribe((result)=>{
    this.route.navigate(['productsearch'])
  },error=>{this.alert=true;
    setTimeout(() => {
      this.route.navigate(['/productsearch']);}, 3000);
  });
  }

  logout(){
    sessionStorage.removeItem('isLoggedIn');
    this.route.navigate(['/login']);
  }

  ngOnInit() {
  }

}
