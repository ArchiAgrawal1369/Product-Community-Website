import { Component, OnInit } from '@angular/core';
import {Product} from '../product'; 
import {NgForm} from '@angular/forms'
import {ProductService} from '../product.service';
import{Router} from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-product-search',
  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.sass']
})
export class ProductSearchComponent implements OnInit {
  listproducts:any=[];
  
  msg="No products found! Try searching with different keywords.";
  alert= false;
  productKey="";
  
  prodSearchByKeyword(){
    console.warn(this.productKey);
    this.prodservice.findByParams(this.productKey).subscribe(result=>{
      this.alert= false;
      this.listproducts=result;
    },error=>{this.alert=true;
              this.listproducts=[]});
  }

  
  // filterByColor(color: string){
  //   this.filteredProducts=this.listproducts.filter((product:any[])=>this.listproducts.productColor === color);
  //   console.warn(this.filteredProducts);
  // }
  filterByColor(color: string){
    this.listproducts= this.listproducts.filter(p => p.productColor=== color);
  }
  filterByBrand(brand: string){
    this.listproducts= this.listproducts.filter(p => p.productBrand=== brand);
  }

  logout(){
    sessionStorage.removeItem('isLoggedIn');
    this.router.navigate(['/login']);
  }
 

  constructor(private prodservice:ProductService, private router:Router) { }

  ngOnInit() {
    this.prodservice.getList().subscribe((result)=>{
      console.warn(result);
      this.listproducts=result;
    })
  }
}
