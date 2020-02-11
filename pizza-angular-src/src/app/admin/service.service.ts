import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PizzaModel } from '../models/pizza.model';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  listPizzas(){
    return this.http.get<PizzaModel[]>("http://localhost:8880/front/generalizedSearch?something=" +"");
  }
}
