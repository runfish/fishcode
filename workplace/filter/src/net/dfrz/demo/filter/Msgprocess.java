package net.dfrz.demo.filter;

public class Msgprocess {
	
	private String msg;
	
//	Filter [] filters = {new HTMLFilter(),new SensitiveFilter()};
	
	private FilterChain fc;

	/**
	 * @return the fc
	 */
	public FilterChain getFc() {
		return fc;
	}

	/**
	 * @param fc the fc to set
	 */
	public void setFc(FilterChain fc) {
		this.fc = fc;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String process(){

		return fc.doFilter(msg);
	}
	
	
	

}
