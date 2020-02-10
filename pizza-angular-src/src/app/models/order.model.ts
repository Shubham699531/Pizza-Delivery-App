import { PizzaModel } from "./pizza.model";
import { CustomerModel } from "./customer.model";

export class OrderModel{
    orderId: number;
    orderStatus:string;
    orderAmount:number;
    orderTime:Date;
    pizzas: PizzaModel[];
    customer:CustomerModel;
}