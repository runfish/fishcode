package net.dfrz.demo.filter;

public class Main {

     public static void main(String[] args) {
		String msg = "大家好，我是小鱼，我会被就业吗？接下来的话会很敏感<script>  <tag>  <hehe>  被就业";
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
