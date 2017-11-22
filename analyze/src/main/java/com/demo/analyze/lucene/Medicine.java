package com.demo.analyze.lucene;

/**
 * 
 *
 *  @version ： 1.0
 *  
 *  @author  ： 苏若年              <a href="mailto:DennisIT@163.com">发送邮件</a>
 *    
 *  @since   ： 1.0        创建时间:    2013-4-7    下午01:52:49
 *     
 *  @function： TODO        
 *
 */
public class Medicine {

    private Integer id;
    private String name;
    private String function;
    
    
    public Medicine() {
        
    }
    
    
    public Medicine(Integer id, String name, String function) {
        super();
        this.id = id;
        this.name = name;
        this.function = function;
    }

    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFunction() {
		return function;
	}


	public void setFunction(String function) {
		this.function = function;
	}


	public String toString(){
        return this.id + "," +this.name + "," + this.function;
    }
}
