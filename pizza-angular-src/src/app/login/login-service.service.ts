import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginModel } from '../models/login.model';
import { CustomLoginObjectModel } from '../models/custom.login.model';
import { CustomerModel } from '../models/customer.model';
import { AdminModel } from '../models/admin.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  currentCustomer:CustomerModel;
  currentAdmin:AdminModel;

  constructor(private http:HttpClient) { }

validateLogin(login:LoginModel){
  return this.http.post<CustomLoginObjectModel>("http://localhost:8883/register/login", login);
}
}
