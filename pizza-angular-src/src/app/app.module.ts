import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CustomerComponent } from './customer/customer.component';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { CustomerRegisterComponent } from './customer/register/register.component';
import { CustomerDashboardComponent } from './customer/dashboard/dashboard.component';
import { SearchPizzaComponent } from './customer/search-pizza/search-pizza.component';
import { CustomerHeaderComponent } from './customer/header/header.component';
import { CustomerSuccessPageComponent } from './customer/success-page/success-page.component';
import { FooterComponent } from './footer/footer.component';
import { ListPizzaComponent } from './list-pizza/list-pizza.component';
import { AdminSuccessPageComponent } from './admin/success-page/success-page.component';
import { AdminRegisterComponent } from './admin/register/register.component';
import { AddPizzaComponent } from './admin/add-pizza/add-pizza.component';
import { AdminDashboardComponent } from './admin/dashboard/dashboard.component';
import { ManageOrdersComponent } from './admin/manage-orders/manage-orders.component';
import { NaviRoutingModule } from './navi/navi-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CustomerComponent,
    AdminComponent,
    HomeComponent,
    CustomerRegisterComponent,
    CustomerDashboardComponent,
    SearchPizzaComponent,
    CustomerHeaderComponent,
    CustomerSuccessPageComponent,
    FooterComponent,
    ListPizzaComponent,
    AdminSuccessPageComponent,
    AdminRegisterComponent,
    AddPizzaComponent,
    AdminDashboardComponent,
    ManageOrdersComponent
  ],
  imports: [
    BrowserModule, FormsModule, NaviRoutingModule, HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
