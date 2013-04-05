function ajaxFunction(){
   var xmlHttp;
   try{ // Firefox, Opera 8.0+, Safari
        xmlHttp=new XMLHttpRequest();
    }
    catch (e){
	   try{// Internet Explorer
	         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	      }
	    catch (e){
	      try{
	         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }
	      catch (e){}
	      }
    }
	return xmlHttp;
 }
 
window.onload=function(){
    document.getElementById("ok").onclick=function(){
	    
		//1 创建XmlHttpRequest对象
		var xmlHttp=ajaxFunction();
		  
		   
		 /*
		  * 
		  * 2 接收服务器返回的数据[注册监听]
		  *   * 怎接收?
		  *   * 什么时候接收呢?
		  *   
		  *   * onreadystatechange事件处理函数由服务器触发，而不是用户
              * 在 Ajax 执行过程中，服务器会通知客户端当前的通信状态。通信状态的改变要激发函数的执行
              * 
              * 
              * readyState 属性表示Ajax请求的当前状态。它的值用数字代表。
					0 代表未初始化。 还没有调用 open 方法
					1 代表正在加载。 open 方法已被调用，但 send 方法还没有被调用
					2 代表已加载完毕。send 已被调用。请求已经开始
					3 代表交互中。服务器正在发送响应
					4 代表完成。响应发送完毕
		  */
		xmlHttp.onreadystatechange=function(){
			 alert(xmlHttp.readyState);
			 //alert(xmlHttp.status);
			 if(xmlHttp.readyState==4){
			 	if(xmlHttp.status==200||xmlHttp.status==304){
					//接收服务器端返回的数据
					var data=xmlHttp.responseText;
					alert(data);
				}
			 }
		}  
		
		/*
		 * 3 打开和服务器的连接
		 *  xmlHttp.open("get","../testServlet",true);
		 *   * 参数1:请求方法  get post
		 *   * 参数2:请求的路径
		 *   * 参数3:表示请求是否要异步传输，默认值为true(异步)
		 */
		xmlHttp.open("get","../testServlet?timeStamp="+new Date().getTime()+"&c=18",true);
		   
		
		/*
		 * 4 发送数据到服务器端
		 *   * 如果请求方法是get,此时send方法不能发送数据到服务器端
		 *     即使发送了数据,服务器端也接收不到,该参数设置null
		 *   * 此时传递参数可以使用url方式传递参数  
		 */
		xmlHttp.send("a=9&b=8");  //xmlHttp.send(null);
		
	}	
}

