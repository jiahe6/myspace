package com.demo.analyze.BKTree;

import java.util.Set;


/**
 * 拼写纠错
 * 
 * @author yifeng
 *
 */
public class SpellChecker {
public static void main(String args[]) {
        double radius = 1.5; // 编辑距离阈值
        String term = "helli"; // 待纠错的词
        
        // 创建BK树
        MetricSpace<String> ms = new LevensteinDistance();
        BKTree<String> bk = new BKTree<String>(ms);
        
        bk.put("hello");
        bk.put("shell");
        bk.put("holl");
        
        Set<String> set = bk.query(term, radius);
        System.out.println(set.toString());
        
    }
}
