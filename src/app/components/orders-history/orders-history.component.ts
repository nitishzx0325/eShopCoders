import { OrderHistoryService } from "./../../services/order-history.service";
import { OrderHistory } from "./../../common/order-history";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-orders-history",
  templateUrl: "./orders-history.component.html",
  styleUrls: ["./orders-history.component.css"],
})
export class OrdersHistoryComponent implements OnInit {
  orderHistoryList: OrderHistory[] = [];
  storage: Storage = sessionStorage;
  constructor(private oderHistoryService: OrderHistoryService) {}

  ngOnInit(): void {
    this.handleOrderHistory();
  }
  handleOrderHistory() {
    // throw new Error("Method not implemented.");
    const theEmail = JSON.parse(this.storage.getItem("userEmail")!);

    this.oderHistoryService.getOrderHistory(theEmail).subscribe((data) => {
      this.orderHistoryList = data._embedded.orders;
    });
  }
}
