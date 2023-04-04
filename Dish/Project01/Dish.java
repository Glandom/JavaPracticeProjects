package com.Project01;

/**
 * ClassName:Dish
 * Package:com.Project01
 * Description:
 * 菜品类的定义
 *
 * @Author: 云峰
 * Create: 2023/4/1 16:23
 * @Version 1.0
 */
//封装菜品的类
public class Dish {
    int id; //编号
    String name;//菜品名称
    double price;//菜品价格

    public Dish() {

    }

    //生成有参构造方法
    public Dish(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //重写toString方法
    @Override
    public String toString() {
        return id + "\t" + name + "\t" + price;
    }
}
