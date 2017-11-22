package com.demo.analyze.AC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
	public static void main(String []args){
		
	//	abcd abc abe ae bc be bce cm kcabcmgh
		
		List<Keyword> keywords = new ArrayList<Keyword>();
		List<Keyword> result = new ArrayList<Keyword> ();
		
		
		
/*		List<Keyword> re= new ArrayList<Keyword> ();	
		re.clear();
		Keyword a= new Keyword("abcd");
		re.add(a);
		Keyword b= new Keyword("abc");
		re.add(b);
		
		System.out.println(re.size());*/
		
		
		
		
		Keyword a1= new Keyword();
		a1.setWord("abcd");
		keywords.add(a1);
		
		Keyword a2= new Keyword();
		a2.setWord("abc");
		keywords.add(a2);
		
		Keyword a3= new Keyword();
		a3.setWord("abe");
		keywords.add(a3);
		
		Keyword a5= new Keyword();
		a5.setWord("ae");
		keywords.add(a5);	
		
		Keyword a6= new Keyword();
		a6.setWord("bc");
		keywords.add(a6);	
		
		Keyword a7= new Keyword();
		a7.setWord("be");
		keywords.add(a7);	
		
		Keyword a8= new Keyword();
		a8.setWord("bce");
		keywords.add(a8);	
		
		Keyword a9= new Keyword();
		a9.setWord("cm");
		keywords.add(a9);	
		
		Patterns patterns=new Patterns(keywords);
		result=patterns.searchKeyword("kcabcmgha", null);
		
//		System.out.println(result.size());
		System.out.println("keys: ");
		for(Keyword key:result){
			System.out.println(key.getWord());
		}
		
	//	System.out.println(result);
	}

}

