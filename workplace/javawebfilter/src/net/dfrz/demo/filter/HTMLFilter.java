package net.dfrz.demo.filter;

public class HTMLFilter implements Filter {


	@Override
	public void doFilter(Request request, Response response,FilterChain chain) {
		// TODO Auto-generated method stub
	  request.requestString = request.requestString.replaceAll("<", "[").replace(">", "]")+"---HTMLFilter";
	  chain.doFilter(request, response, chain);
	  response.responseString += "----HTMLFilter";
		
	}

}