import { Component, OnInit } from '@angular/core';
import { LoginService } from './login-service.service';
import { LoginModel } from '../models/login.model';
import { CustomLoginObjectModel } from '../models/custom.login.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login:LoginModel;
  customLoginObject:CustomLoginObjectModel;

  constructor(private service:LoginService, private router:Router) { }

  ngOnInit() {
    this.login = new LoginModel();
    this.customLoginObject = new CustomLoginObjectModel();
    if(sessionStorage.getItem("userName")!=null){
      this.login.userName=sessionStorage.getItem("userName");
      this.login.password=sessionStorage.getItem("password");
    }
  }

  validateLogin(){
    this.service.validateLogin(this.login).subscribe(data=>{this.customLoginObject=data;
      if(this.customLoginObject.admin==null){
        this.service.currentCustomer=this.customLoginObject.customer;
        sessionStorage.setItem("userName",this.customLoginObject.customer.userName);
        sessionStorage.setItem("password",this.customLoginObject.customer.password);
        sessionStorage.setItem("customerId",this.customLoginObject.customer.customerId.toString());
        this.router.navigate(['customer-dashboard']);
      }
      else{
        this.service.currentAdmin=this.customLoginObject.admin;
        sessionStorage.setItem("userName",this.customLoginObject.admin.userName);
        sessionStorage.setItem("password",this.customLoginObject.admin.password);
        sessionStorage.setItem("adminId",this.customLoginObject.admin.adminId.toString());
        this.router.navigate(['admin-dashboard']);
      }
    })
  }

}
