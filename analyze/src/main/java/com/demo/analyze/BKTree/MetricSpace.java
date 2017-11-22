package com.demo.analyze.BKTree;

/**
 * 度量空间
 * 
 * @author yifeng
 *
 * @param <T>
 */
public interface MetricSpace<T> {

    double distance(T a, T b);
    
}
