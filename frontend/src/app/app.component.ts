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
    this.cartService.getAllCart().subscribe(data => {
      if (data.length > 0) {
        this.cartService.getCartById(1).subscribe((response: Cart) => {
          this.currentProductNumber = response.productModelSet.length;
          console.log("num" + this.currentProductNumber);
        });
      }
    });
  }
}
