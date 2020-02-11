import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../service.service';
import { OrderModel } from 'src/app/models/order.model';
import { CustomerModel } from 'src/app/models/customer.model';
import { LoginService } from 'src/app/login/login-service.service';
import { AdminService } from 'src/app/admin/service.service';
import { PizzaModel } from 'src/app/models/pizza.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class CustomerDashboardComponent implements OnInit {
  customer: CustomerModel;
  orders: OrderModel[]=[];
  pizzas: PizzaModel[]=[];

  constructor(private service:CustomerService, private loginService:LoginService, private adminService:AdminService) {  
  }

  ngOnInit() {
    this.customer = new CustomerModel();
    this.adminService.listPizzas().subscribe(data=>{this.pizzas=data});
    if(sessionStorage.getItem("customerId")!=null){
      this.customer = this.loginService.currentCustomer;
      this.service.fetchOrdersByCustomerId(this.customer.customerId).subscribe(data=>{this.orders=data});
    }
  }

}
