import { Component, OnInit } from '@angular/core';
import {Product} from '../product'; 
import { ActivatedRoute } from '@angular/router';
import {ProductService } from '../product.service'


@Component({
  selector: 'app-product-result',
  templateUrl: './product-result.component.html',
  styleUrls: ['./product-result.component.sass']
})
export class ProductResultComponent implements OnInit {
  prodCode; prodBrand; prodName; prodColor; prodPrice;
  avgRating;
  reviews;
  constructor(private router: ActivatedRoute, private prodService: ProductService) { }

  ngOnInit() {

    this.prodService.getRating(this.router.snapshot.params.id).subscribe((rate)=>{
      console.warn(rate);
      this.avgRating= rate;
    })
    this.prodService.getReviewforProduct(this.router.snapshot.params.id).subscribe((data)=>{
      console.warn(data);
      this.reviews=data;
    })
    this.prodService.getDetail(this.router.snapshot.params.id).subscribe((result)=>{
      this.prodCode= result['productCode'];
      this.prodName= result['productName'];
      this.prodBrand= result['productBrand'];
      this.prodColor= result['productColor'];
      this.prodPrice= result['productPrice'];
      //this.reviews=result['review'];
    })
  }

  

}
