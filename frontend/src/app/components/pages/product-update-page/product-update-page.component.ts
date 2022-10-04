import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../services/product/product.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../../../types/product";
import {HttpErrorResponse} from "@angular/common/http";


@Component({
  selector: 'app-product-update-page',
  templateUrl: './product-update-page.component.html',
  styleUrls: ['./product-update-page.component.css']
})
export class ProductUpdatePageComponent implements OnInit {
  product: Product;
  id: number;

  constructor(private activatedRoute: ActivatedRoute,
  private router: Router,
  private productService: ProductService) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.id = params['productId'];
    });

    this.getProductById(this.id);
  }

  onUpdate(updatedProduct: Product): void {
    this.product.id = updatedProduct.id;
    this.product.productName = updatedProduct.productName;
    this.product.price = updatedProduct.price;
    this.productService.updateProduct(this.product, this.product.id).subscribe(
      data=>{
        console.log(data);
      }
    );
    this.router.navigate(['product']);
  }

  onBack(): void {
    this.router.navigate(['product']);
  }

  public getProductById(productId: number): void {
    this.productService.getProductById(productId).subscribe((response: Product) => {
      this.product = response;
    },
      (error: HttpErrorResponse) => {
        alert(error.message);
        });
  }
}
