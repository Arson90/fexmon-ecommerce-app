import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../../services/product/product.service";
import {Product} from "../../../types/product";
import {NgForm} from "@angular/forms";
import {CartService} from "../../../services/cart/cart.service";
import {HttpErrorResponse} from "@angular/common/http";


@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  products: Product[];
  productById: Product;
  productName: string;
  price: number;

  constructor(private productService: ProductService, private cartService: CartService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  public getProducts(): void {
   this.productService.getProducts().subscribe((response: Product[] ) => {
     this.products = response;
   },
     (error: HttpErrorResponse) => {
        alert(error.message);
      }
     );
  }

  // public getProductById(productId: number): void {
  //   this.productService.getProductById(productId).subscribe((response: Product ) => {
  //     this.productById = response;
  //   });
  // }

  // public addProduct(addForm: NgForm): void {
  //   const productData: Product = {
  //     productName: addForm.value.productName,
  //     price: addForm.value.price
  //   };
  //   this.productService.addProduct(productData).subscribe((response: Product) => {
  //     this.productById = response;
  //   });
  // }

  public addProduct(productId: number): void {
    this.cartService.getAllCart().subscribe(data => {
      if (data.length === 0) {
        this.cartService.createEmptyCart();
      }
    });
    this.cartService.addProductToCart(productId).subscribe(data => {
      console.log(data);
    });
  }
}
