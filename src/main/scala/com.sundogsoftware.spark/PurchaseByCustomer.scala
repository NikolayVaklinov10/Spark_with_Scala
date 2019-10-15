package com.sundogsoftware.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._



object PurchaseByCustomer {

  // Compute the total amount spent per customer in some fake e-commerce data
  // Convert input data to (customerID, amountSpent) tuples
  def extractCustomerPricePairs(line: String) = {
    val fields = line.split(",")
    (fields(0).toInt, fields(2).toFloat)
  }


  def main(args: Array[String]): Unit ={

    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    //Create a SparkContext using every core of the local machine, named PurchasingsCounter
    val sc = new SparkContext("local[*]", "PurchaseByCounter")

    // Load up each line of the customer data into an RDD
    val lines = sc.textFile("./customer-orders.csv")

    val mappedInput = lines.map(extractCustomerPricePairs)

    val totalByCustomer = mappedInput.reduceByKey((x,y) => x + y)

    val results = totalByCustomer.collect()

    // Print the results.
    results.foreach(println)


  }

}







































