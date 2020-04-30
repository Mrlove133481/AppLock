package com.mrlove.lock;
/**
 * 简单工厂模式
 *
 * */
public  abstract class Factory{
    public static Product createProduct(String type){
     Product product = null;
     switch (type){
         case "A":
             product = new ConcreteProductA();
             break;
         case "B":
             product = new ConcreteProductB();
             break;
     }
     return product;
    }
}
