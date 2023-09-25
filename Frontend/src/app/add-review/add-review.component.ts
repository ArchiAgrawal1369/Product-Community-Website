import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import{FormGroup, FormControl} from '@angular/forms';
import{Router} from '@angular/router';
import {ProductService } from '../product.service'


@Component({
  selector: 'app-add-review',
  templateUrl: './add-review.component.html',
  styleUrls: ['./add-review.component.sass']
})
export class AddReviewComponent implements OnInit {
  prodCode;
  reviewDetail= new FormGroup({
    review: new FormControl(),
    state:new FormControl('pending'),
    ratings: new FormControl('')
  })
  constructor(private router: ActivatedRoute, private route:Router, private prodService: ProductService) { }

  addReviewDetail(){
    this.prodService.addReview(this.router.snapshot.params.id, this.reviewDetail.value).subscribe((result)=>{
    this.route.navigate(['productsearch'])
    console.warn(result)
  })
  }

  logout(){
    sessionStorage.removeItem('isLoggedIn');
    this.route.navigate(['/login']);
  }
 
  ngOnInit() {
    this.prodCode=this.router.snapshot.params.id;
  }

}
