import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { CustomerDashboardComponent } from '../customer/dashboard/dashboard.component';
import { CustomerRegisterComponent } from '../customer/register/register.component';
import { ListPizzaComponent } from '../list-pizza/list-pizza.component';
import { AdminDashboardComponent } from '../admin/dashboard/dashboard.component';
import { AdminRegisterComponent } from '../admin/register/register.component';
import { ManageOrdersComponent } from '../admin/manage-orders/manage-orders.component';
import { AdminSuccessPageComponent } from '../admin/success-page/success-page.component';
import { CustomerSuccessPageComponent } from '../customer/success-page/success-page.component';
import { HomeComponent } from '../home/home.component';
import { SearchPizzaComponent } from '../customer/search-pizza/search-pizza.component';
import { AddPizzaComponent } from '../admin/add-pizza/add-pizza.component';

const routes: Routes = [
  {path:"login", component:LoginComponent},
  {path:"customer-dashboard", component:CustomerDashboardComponent},
  {path:"customer-register", component:CustomerRegisterComponent},
  {path:"admin-dashboard", component:AdminDashboardComponent},
  {path:"admin-register", component:AdminRegisterComponent},
  {path:"list-pizza", component:ListPizzaComponent},
  {path:"home", component:HomeComponent},
  {path:"manage-orders", component:ManageOrdersComponent},
  {path:"search-pizza", component:SearchPizzaComponent},
  {path:"admin-success-page", component:AdminSuccessPageComponent},
  {path:"customer-success-page", component:CustomerSuccessPageComponent},
  {path:"add-pizza", component:AddPizzaComponent},
  {path: "", redirectTo:"/login", pathMatch:"full"},
  {path:"**", redirectTo:"/login", pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
