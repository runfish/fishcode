package net.dfrz.demo.filter;

import java.util.Arrays;

public class Main {

     public static void main(String[] args) {
		String msg = "��Һã�����С�㣬�һᱻ��ҵ�𣿽������Ļ��������<script>  <tag>  <hehe>  ����ҵ";
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