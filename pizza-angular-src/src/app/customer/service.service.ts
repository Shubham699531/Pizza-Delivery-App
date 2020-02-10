import { Injectable } from '@angular/core';
import { CustomerModel } from '../models/customer.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  addCustomer(customer:CustomerModel){
    return this.http.post<CustomerModel>("http://localhost:8883/register/registerCustomer", customer);
  }
}
