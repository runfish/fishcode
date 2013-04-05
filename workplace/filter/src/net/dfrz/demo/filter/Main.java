package net.dfrz.demo.filter;

import java.util.Arrays;

public class Main {

     public static void main(String[] args) {
		String msg = "大家好，我是小鱼，我会被就业吗？接下来的话会很敏感<script>  <tag>  <hehe>  被就业";
		Msgprocess msgprocess = new Msgprocess();
		msgprocess.setMsg(msg);
		FilterChain fc = new FilterChain();
		fc.addFilter(new SensitiveFilter());
		FilterChain fc2 = new FilterChain();
		fc2.addFilter(new HTMLFilter());
		fc.addFilter(fc2);
		msgprocess.setFc(fc);
		String result = msgprocess.process();
		System.out.println(result);

		
	}

}
