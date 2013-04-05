package net.dfrz.demo.filter;

public class Main {

     public static void main(String[] args) {
		String msg = "��Һã�����С�㣬�һᱻ��ҵ�𣿽������Ļ��������<script>  <tag>  <hehe>  ����ҵ";
		Request request = new Request();
		request.setRequestString(msg);
		Response response = new Response();
		response.setResponseString("response");
		
		FilterChain fc = new FilterChain();
		fc.addFilter(new SensitiveFilter());
		FilterChain fc2 = new FilterChain();
		fc2.addFilter(new HTMLFilter());
		fc.addFilter(fc2);
		fc.doFilter(request, response, fc);
		System.out.println(request.getRequestString());
		System.out.println(response.getResponseString());
		
	}

}