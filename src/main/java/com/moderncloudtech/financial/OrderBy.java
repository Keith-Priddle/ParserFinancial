package com.moderncloudtech.financial;

public enum OrderBy {
SOURCE("source"), TRANSID("transId");
private String OrderByCode;
private OrderBy(String orderBy) {
this.OrderByCode = orderBy;
}
public String getOrderByCode() {
return this.OrderByCode;
}
}