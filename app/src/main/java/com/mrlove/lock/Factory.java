package com.mrlove.lock;
/**
 * 简单工厂模式
 *
 * */
public  abstract class Factory{
    public abstract <T extends Product> T createProduct(Class<T> mproduct);
}
