import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {ProductSearchComponent} from './product-search/product-search.component';
import {ProductResultComponent} from './product-result/product-result.component';
import {AddReviewComponent} from './add-review/add-review.component';
import {AdminComponent} from './admin/admin.component';
import {AdminControlComponent} from './admin-control/admin-control.component';
import { RaiseReviewComponent } from './raise-review/raise-review.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  
  {
    component:RegisterComponent, path:'register'
  },
  {
    component:LoginComponent, path:'login'
  },
  {
    component:HomeComponent, path:''
  },
  {
    component:ProductSearchComponent, path:'productsearch', canActivate:[AuthGuard]
  },
  {
    component:ProductResultComponent, path:'result/:id', canActivate:[AuthGuard]
  },  
  {
    component:AddReviewComponent, path:'review/:id', canActivate:[AuthGuard]
  },
  {
    component:AdminComponent, path:'admin'
  },
  {
    component:AdminControlComponent, path:'admin/control'
  },
  {
    component:RaiseReviewComponent, path:'raisereview', canActivate:[AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
