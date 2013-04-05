package net.dfrz.demo.filter;

public interface Filter {

	//String doFilter(String src);
	
	void doFilter(Request request,Response response ,FilterChain chain);
}
