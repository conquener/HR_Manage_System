 function  validatea(){
    	var pass = false;
    		if(document.getElementById("idpro").value!=""){

    			var  reg=/^[\u4e00-\u9fa5]{2,20}$/;
    				if(reg.test( document.getElementById("idpro").value)==true){
    					 pass=true;
    					return pass;
    				}else{
    					alert("ְλ���Ʋ����Ϲ淶����������,����2-20֮��");
    					return pass;
    				}		
    		}else{
    			alert("ְλ���Ʋ���Ϊ��");
    			
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
    					alert("ְλ�������Ʋ����Ϲ淶����������,����2-20֮��");
    					return pass;
    				}		
    		}else{
    			alert("ְλ�������Ʋ���Ϊ��");
    			
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
    					alert("ְ�Ʋ����Ϲ淶����������,����2-20֮��");
    					return pass;
    				}		
    		}else{
    			alert("ְ�Ʋ���Ϊ��");
    			
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
    					alert("�������಻���Ϲ淶����������,����2-20֮��");
    					return pass;
    				}		
    		}else{
    			alert("�������಻��Ϊ��");
    			
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
    					alert("ְλ���Ʋ����Ϲ淶����������,��дӢ����ĸ �����֣�����1-20֮��");
    					return pass;
    				}		
    		}else{
    			alert("�������Ʋ���Ϊ��");
    			
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
