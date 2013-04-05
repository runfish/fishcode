package net.dfrz.demo.filter;

public class SensitiveFilter implements Filter {


	@Override
	public void doFilter(Request request, Response response,FilterChain chain) {
		// TODO Auto-generated method stub
		request.requestString = request.requestString.replaceAll("±»¾ÍÒµ", "***")+"---SensitiveFilter";
		chain.doFilter(request, response, chain);
		response.responseString+="--SensitiveFilter";
		
		
	}

}
