import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainPageComponent } from "./components/pages/main-page/main-page.component";
import {CartPageComponent} from "./components/pages/cart-page/cart-page.component";
import {LoginPageComponent} from "./components/pages/login-page/login-page.component";
import {CheckoutPageComponent} from "./components/pages/checkout-page/checkout-page.component";
import {ConfirmationPageComponent} from "./components/pages/confirmation-page/confirmation-page.component";
import {RegistrationPageComponent} from "./components/pages/registration-page/registration-page.component";
import {ProductPageComponent} from "./components/pages/product-page/product-page.component";
import {ProductUpdatePageComponent} from "./components/pages/product-update-page/product-update-page.component";

const routes: Routes = [
  { path: 'cart', component: CartPageComponent},
  { path: 'login', component: LoginPageComponent},
  { path: 'checkout', component: CheckoutPageComponent},
  { path: 'confirmation', component: ConfirmationPageComponent},
  { path: 'registration', component: RegistrationPageComponent},
  { path: 'main', component: MainPageComponent },
  { path: 'product', component: ProductPageComponent},
  { path: 'product-update/:productId', component: ProductUpdatePageComponent},
  { path: '', redirectTo: 'main', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [
  CartPageComponent, LoginPageComponent, CheckoutPageComponent,
  ConfirmationPageComponent, RegistrationPageComponent, MainPageComponent,
  ProductPageComponent, ProductUpdatePageComponent
]
