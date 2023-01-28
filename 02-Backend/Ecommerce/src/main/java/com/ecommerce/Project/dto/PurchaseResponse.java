package com.ecommerce.Project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResponse {
    @NonNull
    private String orderTrackingNumber;
}
