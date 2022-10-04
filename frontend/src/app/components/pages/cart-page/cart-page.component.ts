import { Component, OnInit } from '@angular/core';
import {CartService} from "../../../services/cart/cart.service";
import {Cart} from "../../../types/cart";
import {Product} from "../../../types/product";

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit {
  cart: Cart;
  productList: Product[];

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.getCart();
  }

  public getCart(): void {
    this.cartService.getCartById(1).subscribe((response: Cart) => {
      this.cart = response;
      this.productList = response.productModelSet;
    });
  }
}
