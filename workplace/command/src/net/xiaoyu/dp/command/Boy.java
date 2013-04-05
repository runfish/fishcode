package net.xiaoyu.dp.command;

import java.util.ArrayList;
import java.util.List;

public class Boy {

	
	private String name;
	
	private List<Command> commList = new ArrayList<Command>();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public void pursue(MM mm){

		
	}
	
	public void order(Boy b){
		Command command = new ShopingCommand();
		b.addCommand(command);
		command = new HugCommand();
		b.addCommand(command);
		
	}
	
	public void addCommand(Command c){
		this.commList.add(c);
	}
	
	public void execute(){
		for(Command c:commList){
			c.execute();
		}
	}
	
	public void undo(){
		
		
	}
	
}
