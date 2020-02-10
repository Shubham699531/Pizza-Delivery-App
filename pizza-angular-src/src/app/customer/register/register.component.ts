import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../service.service';
import { CustomerModel } from 'src/app/models/customer.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class CustomerRegisterComponent implements OnInit {
  customer: CustomerModel;

  constructor(private service:CustomerService, private router: Router) { }

  ngOnInit() {
    this.customer = new CustomerModel();
  }

  addCustomer(){
    this.service.addCustomer(this.customer).subscribe(data=>{sessionStorage.setItem("userName",data.userName);
    sessionStorage.setItem("customerId", data.customerId.toString());
    sessionStorage.setItem("password", data.password);
    this.router.navigate(['login']);})
  }

}
