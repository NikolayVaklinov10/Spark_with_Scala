package com.cfamilycomputers.spark

import org.apache.spark.{SparkConf, SparkContext}

object FirstSparkApplication {

  def main(args: Array[String]): Unit = {
    // Create a SparkConfig object and SparkContext object to initialize Spark
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("First Application")

    val sc = new SparkContext(conf)

    // create RDD
    val rdd1 = sc.makeRDD(Array(1,2,3,4,5,6))
    rdd1.collect().foreach(println)
  }

}
