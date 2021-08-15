package com.wyx.algo.exampl;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @ClassName WeightRandom
 * @Description TODO
 * @Author yuxiang
 * @Date 2021/8/12
 * @Version 1.0
 **/
public class WeightRandom<K,V extends Number> {

    public static void main(String[] args) {

/*
如有4个元素A、B、C、D，权重分别为1、2、3、4，随机结果中A:B:C:D的比例要为1:2:3:4。
总体思路：累加每个元素的权重A(1)-B(3)-C(6)-D(10)，则4个元素的的权重管辖区间分别为[0,1)、[1,3)、[3,6)、[6,10)。然后随机出一个[0,10)之间的随机数。落在哪个区间，则该区间之后的元素即为按权重命中的元素。
　　实现方法：
利用TreeMap，则构造出的一个树为:
　　　　    B(3)
　　　 /      \
   /         \
 A(1)     D(10)
             /
           /
         C(6)
然后，利用treemap.tailMap().firstKey()即可找到目标元素。
当然，也可以利用数组+二分查找等来实现。*/

        Pair pair1 = new Pair("a", 11);
        Pair pair2 = new Pair("b", 22);
        Pair pair3 = new Pair("c", 33);
        List<Pair> list = new ArrayList<Pair>();
        list.add(pair1);
        list.add(pair2);
        list.add(pair3);

        WeightRandom weightRandom = new WeightRandom(list);
        Object random = weightRandom.random();
        System.out.println(random);
    }

    static class Pair<K, V>{
        private K key;
        private V value;
        public Pair(){}
        public Pair(K k, V v){
            this.key = k;
            this.value = v;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private TreeMap<Double, K> weightMap = new TreeMap<Double, K>();

    public WeightRandom(List<Pair<K, V>> list) {
        //参数检查的工具类--Preconditions类， 该类可以大大地简化我们代码中对于参数的预判断和处理，让我们对方法输入参数的验证实现起来更加简单优雅
        Preconditions.checkNotNull(list, "list can NOT be null!");
        for (Pair<K, V> pair : list) {
            Preconditions.checkArgument(pair.getValue().doubleValue() > 0, String.format("非法权重值：pair=%s", pair));
            double lastWeight = this.weightMap.size() == 0 ? 0 : this.weightMap.lastKey().doubleValue();//统一转为double
            this.weightMap.put(pair.getValue().doubleValue() + lastWeight, pair.getKey());//权重累加
        }
    }

    public K random() {
        //Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
        double randomWeight = this.weightMap.lastKey() * Math.random();
        //Open Declaration NavigableMap<Double, K> java.util.TreeMap.tailMap(Double fromKey, boolean inclusive)
        SortedMap<Double, K> tailMap = this.weightMap.tailMap(randomWeight, false);
        return this.weightMap.get(tailMap.firstKey());
    }

}
