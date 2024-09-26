package com.ypan.project.aspect;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 目标：现在有一个List<Product>。我们期望list中productId都是不重复的。但是因为上游操作的问题，传给我们的list中有部分productId相同的数据，我们需要先对他们进行聚合。
 * <p>
 * 例如list中有2个元素(productId:1,price:5,num:10),(productId:1,price:5,num:3),则需要聚合成(productId:1,price:5,num:13) 聚合后，根据总价进行从大到小的排序，总价一样的情况下根据单价从大到小排序。
 * <p>
 * 请写一个函数，入参是原始的List<Product>，出参是最后排序好的集合。
 */


class Test {
    public class Product {
        /*商品ID*/
        private long productId;
        /*单价*/
        private double price;
        /*数量*/
        private long num;

        public long getProductId() {
            return productId;
        }

        public void setProductId(long productId) {
            this.productId = productId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public long getNum() {
            return num;
        }

        public void setNum(long num) {
            this.num = num;
        }
    }

    public List<Product> transform(List<Product> list) {
        // 在此处实现方法逻辑
        Map<Long, List<Product>> map = list.stream().collect(Collectors.groupingBy(Product::getProductId));
        List<Product> res = new ArrayList<>(list.size());
        Set<Long> ids = map.keySet();
        ids.forEach(id -> {
            List<Product> products = map.get(id);
            Product product = new Product();
            Long numSum = 0L;
            for (Product product1 : products) {
                long num = product1.getNum();
                numSum += num;
            }
            product.setNum(numSum);
            product.setProductId(id);
            product.setPrice(products.get(0).getPrice());
            res.add(product);
        });


        List<Product> collect = res.stream().sorted(new MyCom()).collect(Collectors.toList());

        List<Product> collect1 = res.stream().sorted((o1, o2) -> (int) (o1.price * o1.num - o2.price * o2.num)).collect(Collectors.toList());
        return null;
    }

    static class MyCom implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return (int) (o1.price * o1.num - o2.price * o2.num);
        }
    }
}
