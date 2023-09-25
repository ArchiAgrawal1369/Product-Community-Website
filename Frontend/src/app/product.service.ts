import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './product';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private search="http://localhost:8086/search";
  private getlist="http://localhost:8086/product";
  private url="http://localhost:8086/details";
  private review="http://localhost:8086/review";
  private rating="http://localhost:8086/rating";
  private product="http://localhost:8086/product";

  constructor(private httpClient:HttpClient, private router:Router) { }

  findByNameAndBrand(prod: Product): Observable<any>{
    return this.httpClient.post<any>(`${this.search}`,prod);
    }

  findByParams(id){
    return this.httpClient.get(`${this.search}/${id}`);
  }

  getList() {
    return this.httpClient.get(this.getlist);
  }
 
  getDetail(id){
    return this.httpClient.get(`${this.url}/${id}`)
  }

  getReviews() {
    return this.httpClient.get(this.review);
  }

  getReviewforProduct(id){
    return this.httpClient.get(`${this.review}/${id}`)
  }
  addReview(id,data){
    return this.httpClient.post(`${this.review}/${id}`,data)
  }
  addProduct(data){
    return this.httpClient.post(`${this.product}`,data)
  }

  getRating(id){
    return this.httpClient.get(`${this.rating}/${id}`)
  }
  approveReview(id){
    return this.httpClient.put(`${this.review}/${id}`,"approved"); 
  }
  rejectReview(id){
    return this.httpClient.put(`${this.review}/${id}`,"reject");
  }
}
