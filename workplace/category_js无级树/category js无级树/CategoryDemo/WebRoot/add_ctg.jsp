<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      
    <title>新增类别</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="content-type" content="text/html; charset=gb2312" />
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="js/prototype.js"></script>
	
	<style>
	    
	    body,span,div,ul,li,select,input,option{
	       margin:0px;
	       padding:0px;
	       font-size:12px;
	       font-family:verdana;
	    }
	    
	    #wrapper{
	       margin-top:20px;
	       margin-left:20px;	       
	    }
	    
	    .formRow{
	       margin-top:10px;
	    }
	    
	    .rowHeader{
	      width:60px;
	      text-align:right;
	    }
	    
	    .formRow select{
	      margin-left:5px;
	    }
	    
	    #ctgSelectArea{
	      margin-top:5px;
	    }
	    
	    
	    
	    
	</style>
	
	<script type="text/javascript">
	
	    var g_sel_cnt=0; //全局select元素数量,根据类别层次深度的不同，页面出现的类别select数量也不同。
	    
	    function buildSelector(ctgPid){

	       new Ajax.Request(
            encodeURI("ctgMgr?act=getSubCtgs&seed="+Math.random()+"&ctgPid="+parseInt(ctgPid)),
            {
              method:"get",
              onComplete:function(xhr){
              
                  //如果子级别查询不存在，则不再继续创建下级类别
                  if(xhr.responseText==""){ 
                     //alert("不存在下级类别，操作停止!");
                     return;
                  }
                  
                  var subCtgInfo="-1:=请选择=|0:[顶级类别]|"+xhr.responseText;
                  var optionStr=subCtgInfo.split("|");
                                                   
                  var sel=document.createElement("SELECT");
                  g_sel_cnt++;//新增select
                  sel.id="sel"+g_sel_cnt; //设置新创建的select的id.
                  
                  //设置该select的option
                  
                  for(i=0;i<optionStr.length;i++){
                     if(i==1&&g_sel_cnt!=1) continue; //只有第一级select才封装顶级类别选项
                     var opt=document.createElement("OPTION");
                     opt.value=optionStr[i].split(":")[0];
                     opt.text=optionStr[i].split(":")[1];
                     sel.add(opt,sel.options[null]); //类似于append到select的options的末尾。
                  }
                  
                  sel.onchange=function(){
                  
                                var ctgPid=this.options[this.selectedIndex].value;//要查询子类别的父类别                                                                                             
                                var level=parseInt(this.id.charAt(3));//当前操作的select的级别
                                                                
                                
                               // alert("level:"+level+",g_count:"+g_sel_cnt);
                               // alert($('ctgSelectArea').childNodes.length);
                                //for(i=0;i<$('ctgSelectArea').childNodes.length;i++)
                                //  alert($('ctgSelectArea').childNodes[i].tagName);
                                
                                var delTimes=g_sel_cnt-level;
                                for(i=1;i<=delTimes;i++){
                                    $('ctgSelectArea').removeChild($('ctgSelectArea').lastChild);
                                    g_sel_cnt--; //全局计数器减1
                                }
                                
                                var ctgLinkStr="";
                                for(i=1;i<=g_sel_cnt;i++){
                                  with($('sel'+i)){
                                    if(options[selectedIndex].value!=-1){
                                      if(i==1) 
                                        ctgLinkStr=options[selectedIndex].text;
                                      else
                                        ctgLinkStr+="->"+options[selectedIndex].text;
                                    }
                                  }
                                }

                               // alert(ctgLinkStr);
                                                                
                                if(ctgPid!=-1) buildSelector(ctgPid);
                                
                                if(ctgPid==-1 && level!=1){ //用户选择了非第一级"请选择",选择上一级值替代
                                  with($('sel'+(--level))){
                                     ctgPid=options[selectedIndex].value;
                                  }
                                }
                                
                                document.forms[0].ctgpid.value=ctgPid;//设置隐藏域保存
                                
                                $("ctglink").innerText=(ctgLinkStr==""?"[尚未设置]":ctgLinkStr);
                                
                               }
                  
                   $('ctgSelectArea').appendChild(sel);
                                 
              }
            }            
           );
          
	    }
	
	</script>
	
  </head>
  
  <body onload="buildSelector(0)">
  
    <form action="ctgMgr" method="post">
        <input type="hidden" name="act" value="createCtg"/>
	    <div id="wrapper">
		    <h3>新增类别</h3>
		    <div class="formRow">
		      <span class="rowHeader">类别名称:</span>
		      <input type="text" name="ctgname"/>
		    </div>
		    <div class="formRow">
		      <span class="rowHeader">上级类别:</span>
		      <span id="ctgLink">[尚未设置]</span>
		      <input type="hidden" name="ctgpid"/>
		      <div id="ctgSelectArea"><span class="rowHeader">设置:</span></div>
		    </div>
		    <div class="formRow">
		      <span class="rowHeader">链接地址:</span>
		      <input type="text" name="ctglinkurl" size="50"/>
		    </div>
		    <div class="formRow">
		      <input type="submit" value="创建类别"/>
		    </div> 
	    </div>
    </form>
    
  </body>
  
</html>
