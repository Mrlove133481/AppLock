package com.mrlove.lock;

public class MyFactory extends Factory {
    @Override
    public <T extends Product> T createProduct(Class<T> mproduct) {
        Product product = null;
        String className = mproduct.getName();
        try {
            product = (Product)Class.forName(className).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return (T) product;
    }
}
