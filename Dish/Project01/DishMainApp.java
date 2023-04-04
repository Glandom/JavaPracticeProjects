package com.Project01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName:testMain
 * Package:com.Project01
 * Description:
 * 点菜的主函数   设计的点菜简略函数
 *
 * @Author: 云峰
 * Create: 2023/4/1 16:17
 * @Version 1.0
 */

//提前准备菜品 等顾客过来的时候展示
//定义好一个集合 将菜存到里面
public class DishMainApp {
    //用来储存菜品
    static List<Dish> dishList = new ArrayList<>();

    //吃饭的用户已点的菜品
    static List<Dish> personList = new ArrayList<>();

    public static void main(String[] args) {
        //初始化菜品
        initDish();
        //创建扫描器对象 接收控制台输入的信息
        Scanner sc = new Scanner(System.in);

        while (true) {
            //1.给用户展示菜单
            showMenu();
            //接受用户输入的编号
            int recNum = sc.nextInt();
            switch (recNum) {
                case 1:
                    while (true) {
                        //显示菜单
                        showDishMenu();
                        int id = sc.nextInt();
                        //System.out.println("你输入的菜品序号为：" + id);
                        //如果用户输入为0则退出点菜
                        if (id == 0) {
                            break;
                        }
                        Dish dish = dishList.get(id - 1);
                        System.out.println("亲，您点了：" + dish.name);
                        //用户点一个菜便存一个菜
                        personList.add(dish);
                    }
                    break;
                case 2:
                    //显示已点菜品
                    showPersonMenu();
                    sc.nextInt();
                    break;
                case 3:
                    //买单
                    buy();

                    return; //退出循环 即程序结束
                default:
                    System.out.println("输入编号错误");
                    break;
            }
        }

    }

    //主菜单
    public static void showMenu() {
        System.out.println("----------主菜单----------");
        System.out.println("菜单\t\t\t1");
        System.out.println("已点菜品\t\t2");
        System.out.println("买单\t\t\t3");
        System.out.println("-----根据编号请选择服务-----");
    }


    //显示饭店菜品菜单
    public static void showDishMenu() {
        System.out.println("----请您点菜-----");
        //遍历循环输出菜单
        for (int i = 0; i < dishList.size(); i++) {
            //从集合中使用i获取每一个菜品对象
            Dish dish = dishList.get(i);
            System.out.println(dish.toString());
        }
        System.out.println("------输入序号点菜，按0返回上一级-------");
    }

    //显示顾客已点菜单
    public static void showPersonMenu() {
        System.out.println("----您点的菜有：-----");
        //遍历循环输出已点的菜
        for (int i = 0; i < personList.size(); i++) {
            //从集合中使用i获取每一个菜品对象
            Dish dish = personList.get(i);
            System.out.println(dish.toString());
        }
        System.out.println("------按0返回上一级-------");
    }

    //结账
    public static void buy() {
        System.out.println("----您点的菜有：-----");
        double priceSum = 0;//保存总价格
        //遍历循环输出已点的菜
        for (int i = 0; i < personList.size(); i++) {
            //从集合中使用i获取每一个菜品对象
            Dish dish = personList.get(i);
            System.out.println(dish.toString());
            priceSum += dish.price;
        }
        //String.format("%.2f", priceSum)  使用format方法 保留两位小数
        System.out.println("总价为：" + String.format("%.2f", priceSum) + "元");
        System.out.println("欢迎您下次光临！");
    }

    //初始化一些菜品
    public static void initDish() {
        Dish dish1 = new Dish(1, "鱼香肉丝", 35.5);
        dishList.add(dish1);

        //存放菜品  简化写法
        dishList.add(new Dish(2, "黄焖鸡", 25.3));
        dishList.add(new Dish(3, "油焖大虾", 55.9));
        dishList.add(new Dish(4, "地三鲜", 26));
        dishList.add(new Dish(5, "家常凉菜", 18.5));
        dishList.add(new Dish(6, "红烧肉", 35));
    }
}
