import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {CartService} from "./services/cart/cart.service";
import {Cart} from "./types/cart";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'frontend test';
  currentProductNumber: number;

  constructor(private router: Router, private cartService: CartService) {
  }
  ngOnInit(): void {
   this.getCurrentProductNumber()
  }

  public getCurrentProductNumber(): void {
    console.log("Test");
    this.cartService.getCartById(1).subscribe((response: Cart) => {
      console.log("Dupa" + response);
      if (response===null) {

      };
      this.currentProductNumber = response.productModelSet.length;
    });
  }
}
