package com.demo.analyze.lucene;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 *  @version ： 1.0
 *  
 *  @author  ： 苏若年              <a href="mailto:DennisIT@163.com">发送邮件</a>
 *    
 *  @since   ： 1.0        创建时间:    2013-4-7    下午01:54:34
 *     
 *  @function： TODO        
 *
 */
public class DataFactory {

    
    private static DataFactory dataFactory = new DataFactory();
    
    private DataFactory(){
        
    }
    
    public List<Medicine> getData(){
        List<Medicine> list = new ArrayList<Medicine>();
        list.add(new Medicine(1,"银花 感冒颗粒","功能主治：银花感冒颗粒 ，头痛,清热，解表，利咽。"));
        list.add(new Medicine(2,"感冒 止咳糖浆","功能主治：感冒止咳糖浆,解表清热，止咳化痰。"));
        list.add(new Medicine(3,"感冒灵颗粒","功能主治：解热镇痛。头痛 ,清热。"));
        list.add(new Medicine(4,"感冒灵胶囊","功能主治：银花感冒颗粒 ，头痛,清热，解表，利咽。"));
        list.add(new Medicine(5,"仁和 感冒颗粒","功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。"));
        return list;
        
    }
    
    public static DataFactory getInstance(){
        return dataFactory;
    }
}
