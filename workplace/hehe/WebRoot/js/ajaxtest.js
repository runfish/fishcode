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
	    
		//1 ����XmlHttpRequest����
		var xmlHttp=ajaxFunction();
		  
		   
		 /*
		  * 
		  * 2 ���շ��������ص�����[ע�����]
		  *   * ������?
		  *   * ʲôʱ�������?
		  *   
		  *   * onreadystatechange�¼��������ɷ������������������û�
              * �� Ajax ִ�й����У���������֪ͨ�ͻ��˵�ǰ��ͨ��״̬��ͨ��״̬�ĸı�Ҫ����������ִ��
              * 
              * 
              * readyState ���Ա�ʾAjax����ĵ�ǰ״̬������ֵ�����ִ���
					0 ����δ��ʼ���� ��û�е��� open ����
					1 �������ڼ��ء� open �����ѱ����ã��� send ������û�б�����
					2 �����Ѽ�����ϡ�send �ѱ����á������Ѿ���ʼ
					3 �������С����������ڷ�����Ӧ
					4 ������ɡ���Ӧ�������
		  */
		xmlHttp.onreadystatechange=function(){
			 alert(xmlHttp.readyState);
			 //alert(xmlHttp.status);
			 if(xmlHttp.readyState==4){
			 	if(xmlHttp.status==200||xmlHttp.status==304){
					//���շ������˷��ص�����
					var data=xmlHttp.responseText;
					alert(data);
				}
			 }
		}  
		
		/*
		 * 3 �򿪺ͷ�����������
		 *  xmlHttp.open("get","../testServlet",true);
		 *   * ����1:���󷽷�  get post
		 *   * ����2:�����·��
		 *   * ����3:��ʾ�����Ƿ�Ҫ�첽���䣬Ĭ��ֵΪtrue(�첽)
		 */
		xmlHttp.open("get","../testServlet?timeStamp="+new Date().getTime()+"&c=18",true);
		   
		
		/*
		 * 4 �������ݵ���������
		 *   * ������󷽷���get,��ʱsend�������ܷ������ݵ���������
		 *     ��ʹ����������,��������Ҳ���ղ���,�ò�������null
		 *   * ��ʱ���ݲ�������ʹ��url��ʽ���ݲ���  
		 */
		xmlHttp.send("a=9&b=8");  //xmlHttp.send(null);
		
	}	
}

