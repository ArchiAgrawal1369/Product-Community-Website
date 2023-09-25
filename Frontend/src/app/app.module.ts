import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { ProductSearchComponent } from './product-search/product-search.component';
import { ProductResultComponent } from './product-result/product-result.component';
import { AddReviewComponent } from './add-review/add-review.component';
import { AdminComponent } from './admin/admin.component';
import { AdminControlComponent } from './admin-control/admin-control.component';
import { RaiseReviewComponent } from './raise-review/raise-review.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    ProductSearchComponent,
    ProductResultComponent,
    AddReviewComponent,
    AdminComponent,
    AdminControlComponent,
    RaiseReviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
