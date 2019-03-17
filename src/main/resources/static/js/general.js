
	
$(document).ready(function(){
	$("li.nav").mouseover(function() {
	  $(this).find("span").addClass( "oculta" , 1000 );
	  $(this).find("ul").removeClass("oculta" , 1000);
	});
	
	$("li.nav").mouseout(function() {
		  $( this ).find("ul").addClass( "oculta", 1000);
		  $( this ).find("span").removeClass("oculta", 1000);
	});
});



//window.onload=function(){
//   
//	 var liDesplegable= document.querySelectorAll("li.nav");
//	 
//	 for(var i=0; i<liDesplegable.length; i++){
//		 liDesplegable[i].addEventListener("mouseove", desplegarLi);
//		 liDesplegable[i].addEventListener("mouseout", ocultarLi);
//	 }
//	 
//	 var img= document.getElementsByClassName("locales");
//	 
//	 for(var i=0; i<img.length; i++){
//	     img[i].addEventListener("click", interna);
//	}
//	 
//	 document.addEventListener("keypress", escape,true);
	 
	
//}
//
//function desplegarLi(e){
//	var span= e.target.firstChild;
//	var ul = e.target.lastChild;
//	
//	span.classList.addClass("oculta")
//	ul.classList.remove("oculta");
//}





