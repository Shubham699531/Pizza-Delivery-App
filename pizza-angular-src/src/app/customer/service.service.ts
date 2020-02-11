import { Injectable } from '@angular/core';
import { CustomerModel } from '../models/customer.model';
import { HttpClient } from '@angular/common/http';
import { OrderModel } from '../models/order.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  addCustomer(customer:CustomerModel){
    return this.http.post<CustomerModel>("http://localhost:8880/front/registerCustomer", customer);
  }

  fetchOrdersByCustomerId(customerId:number){
    return this.http.get<OrderModel[]>("http://localhost:8880/front/getOrdersByCustomerId?customerId=" + +customerId);
  }
}
