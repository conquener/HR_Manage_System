 function  validatea(){
    	var pass = false;
    		if(document.getElementById("idpro").value!=""){

    			var  reg=/^[\u4e00-\u9fa5]{2,20}$/;
    				if(reg.test( document.getElementById("idpro").value)==true){
    					 pass=true;
    					return pass;
    				}else{
    					alert("职位名称不符合规范，必须中文,长度2-20之间");
    					return pass;
    				}		
    		}else{
    			alert("职位名称不能为空");
    			
    			return pass;
    		}
}


function  validateb(){
    	var pass = false;
    		if(document.getElementById("zl").value!=""){

    			var  reg=/^[\u4e00-\u9fa5]{2,20}$/;
    				if(reg.test( document.getElementById("zl").value)==true){
    					 pass=true;
    					return pass;
    				}else{
    					alert("职位分类名称不符合规范，必须中文,长度2-20之间");
    					return pass;
    				}		
    		}else{
    			alert("职位分类名称不能为空");
    			
    			return pass;
    		}
}
function  validatec(){

    	var pass = false;
    		if(document.getElementById("zhicheng").value!=""){

    			var  reg=/^[\u4e00-\u9fa5]{2,20}$/;
    				if(reg.test( document.getElementById("zhicheng").value)==true){
    					 pass=true;
    					return pass;
    				}else{
    					alert("职称不符合规范，必须中文,长度2-20之间");
    					return pass;
    				}		
    		}else{
    			alert("职称不能为空");
    			
    			return pass;
    		}
			}
function  validated(){
    	var pass = false;
    		if(document.getElementById("sl").value!=""){

    			var  reg=/^[\u4e00-\u9fa5]{2,20}$/;
    				if(reg.test( document.getElementById("sl").value)==true){
    					 pass=true;
    					return pass;
    				}else{
    					alert("属性种类不符合规范，必须中文,长度2-20之间");
    					return pass;
    				}		
    		}else{
    			alert("属性种类不能为空");
    			
    			return pass;
    		}
}



function  validatee(){
    	var pass = false;
    		if(document.getElementById("mingcheng").value!=""){

    			var  reg=/^[\u4e00-\u9fa5]|[A-Za-z0-9]{1,20}$/;
    				if(reg.test( document.getElementById("mingcheng").value)==true){
    					 pass=true;
    					return pass;
    				}else{
    					alert("职位名称不符合规范，必须中文,大写英文字母 ，数字，长度1-20之间");
    					return pass;
    				}		
    		}else{
    			alert("属性名称不能为空");
    			
    			return pass;
    		}
}
function  validateh(){
        var pass = false;
		if(validated()){
		     if(validatee()){
			  pass=true;
			  return pass;
		}else{
		   return pass;
		}
		}
		else{
		return  pasa;
		}
}
