package com.example.Transaction;

public class TransactionReq {
 int count;
 long timestamp;
 double amount,total,avg;
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public long getTimestamp() {
	return timestamp;
}
public void setTimestamp(long timestamp) {
	this.timestamp = timestamp;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public double getAvg() {
	return avg;
}
public void setAvg(double avg) {
	this.avg = avg;
}
 
}
