import { OrderModel } from "./order.model";

export class PizzaModel{
    pizzaId: number;
    pizzaName: string;
    pizzaDesc:string;
    pizzaSize:string;
    crustType:string;
    extraCheese:boolean;
    pizzaType:string;
    pizzaStatus:string;
    toppings:string;
    cost:number;
    imageUrl:string;
    order:OrderModel;
}