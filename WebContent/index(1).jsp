<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7,8,9" />
<meta name="keywords" content="javascript, fondo, fondo web" />
<meta name="description" content="Redimensiona la ventana para ver como la imagen se adapta a cualquier resoluci�n con Javascript. No solo CSS" lang="ES" />
<link href='http://fonts.googleapis.com/css?family=Architects+Daughter' rel='stylesheet' type='text/css'>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Proyecto Lecoib: Index</title>

<style type="text/css">

body{
	font-family: 'Architects Daughter', cursive;
	color:#333;
	font-size:25px;
	font-weight:bold;
}
a{
	text-decoration:none;
	font-family: 'Black Ops One', cursive;
	font-size:20px;
	color:#222;

}
a:hover{

	color:#DF7401;
	
}
.nsc{
	position:absolute;
	bottom:0;
	right:10px;

}
.center{
	position:absolute;
	padding:0 10px 0 10px;
	width:500px;
	height:500px;
	top:50%;
	left:50%;
	margin-left:-250px;
	margin-top:-250px;
	background-color: rgba(245, 218, 129, 0.50);
	

}
h1{
	font-size:20px;
}
h1 p{

	background:#222;
	color:#fff;
	padding:10px;
	


}
#bg{

	position:fixed;
	top:0;
	left:0;
	z-index:-1;

}

.bgwidth{

	width:100%;
	height:auto;

}

.bgheight{

	height:100%;
	width:auto;


}


</style>

</head>
<body style="font-family:Arial, Verdana;background-color:#fff;">

<img src='static/img/pasillo.jpg'/>	

<script> 

window.onload = function() {



	function bgadj(){
		
		
		var element = document.getElementById("bg");
		
		var ratio =  element.width / element.height;	
		
		if ((window.innerWidth / window.innerHeight) < ratio){
		
			element.style.width = 'auto';
			element.style.height = '100%';
			
			//<!-- si la imagen es mas ancha que la ventana la centro -->
			if (element.width > window.innerWidth){
			
				var ajuste = (window.innerWidth - element.width)/2;
				
				element.style.left = ajuste+'px';
			
			}
		
		}
		else{	
		
			element.style.width = '100%';
			element.style.height = 'auto';
			element.style.left = '0';

		}
		
	}
//<!-- llamo a la funci�n bgadj() por primera vez al terminar de cargar la p�gina -->
	bgadj();
	//<!-- vuelvo a llamar a la funci�n  bgadj() al redimensionar la ventana -->
	window.onresize = function() { 
		bgadj();

	}

}


	

</script>

	<%@ include file="/jsp/cabecera.jsp" %>

<!-- it works the same with all jquery version from 1.x to 2.x -->
    <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
    <!-- use jssor.slider.mini.js (40KB) instead for release -->
    <!-- jssor.slider.mini.js = (jssor.js + jssor.slider.js) -->
    <script type="text/javascript" src="../js/jssor.js"></script>
    <script type="text/javascript" src="../js/jssor.slider.js"></script>
    <script>

        jQuery(document).ready(function ($) {

            var _SlideshowTransitions = [
            //Fade
            { $Duration: 1200, $Opacity: 2 }
            ];

            var options = {
                $AutoPlay: true,                                    //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
                $AutoPlaySteps: 1,                                  //[Optional] Steps to go for each navigation request (this options applys only when slideshow disabled), the default value is 1
                $AutoPlayInterval: 3000,                            //[Optional] Interval (in milliseconds) to go for next slide since the previous stopped if the slider is auto playing, default value is 3000
                $PauseOnHover: 1,                               //[Optional] Whether to pause when mouse over if a slider is auto playing, 0 no pause, 1 pause for desktop, 2 pause for touch device, 3 pause for desktop and touch device, 4 freeze for desktop, 8 freeze for touch device, 12 freeze for desktop and touch device, default value is 1

                $ArrowKeyNavigation: true,   			            //[Optional] Allows keyboard (arrow key) navigation or not, default value is false
                $SlideDuration: 500,                                //[Optional] Specifies default duration (swipe) for slide in milliseconds, default value is 500
                $MinDragOffsetToSlide: 20,                          //[Optional] Minimum drag offset to trigger slide , default value is 20
                //$SlideWidth: 600,                                 //[Optional] Width of every slide in pixels, default value is width of 'slides' container
                //$SlideHeight: 300,                                //[Optional] Height of every slide in pixels, default value is height of 'slides' container
                $SlideSpacing: 0, 					                //[Optional] Space between each slide in pixels, default value is 0
                $DisplayPieces: 1,                                  //[Optional] Number of pieces to display (the slideshow would be disabled if the value is set to greater than 1), the default value is 1
                $ParkingPosition: 0,                                //[Optional] The offset position to park slide (this options applys only when slideshow disabled), default value is 0.
                $UISearchMode: 1,                                   //[Optional] The way (0 parellel, 1 recursive, default value is 1) to search UI components (slides container, loading screen, navigator container, arrow navigator container, thumbnail navigator container etc).
                $PlayOrientation: 1,                                //[Optional] Orientation to play slide (for auto play, navigation), 1 horizental, 2 vertical, 5 horizental reverse, 6 vertical reverse, default value is 1
                $DragOrientation: 3,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)

                $SlideshowOptions: {                                //[Optional] Options to specify and enable slideshow or not
                    $Class: $JssorSlideshowRunner$,                 //[Required] Class to create instance of slideshow
                    $Transitions: _SlideshowTransitions,            //[Required] An array of slideshow transitions to play slideshow
                    $TransitionsOrder: 1,                           //[Optional] The way to choose transition to play slide, 1 Sequence, 0 Random
                    $ShowLink: true                                    //[Optional] Whether to bring slide link on top of the slider when slideshow is running, default value is false
                },

                $BulletNavigatorOptions: {                                //[Optional] Options to specify and enable navigator or not
                    $Class: $JssorBulletNavigator$,                       //[Required] Class to create navigator instance
                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $AutoCenter: 1,                                 //[Optional] Auto center navigator in parent container, 0 None, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
                    $Steps: 1,                                      //[Optional] Steps to go for each navigation request, default value is 1
                    $Lanes: 1,                                      //[Optional] Specify lanes to arrange items, default value is 1
                    $SpacingX: 10,                                   //[Optional] Horizontal space between each item in pixel, default value is 0
                    $SpacingY: 10,                                   //[Optional] Vertical space between each item in pixel, default value is 0
                    $Orientation: 1                                 //[Optional] The orientation of the navigator, 1 horizontal, 2 vertical, default value is 1
                },

                $ArrowNavigatorOptions: {
                    $Class: $JssorArrowNavigator$,              //[Requried] Class to create arrow navigator instance
                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $Steps: 1                                       //[Optional] Steps to go for each navigation request, default value is 1
                }
            };
            var jssor_slider1 = new $JssorSlider$("slider1_container", options);

            //responsive code begin
            //you can remove responsive code if you don't want the slider scales while window resizes
            function ScaleSlider() {
                var parentWidth = jssor_slider1.$Elmt.parentNode.clientWidth;
                if (parentWidth)
                    jssor_slider1.$ScaleWidth(Math.min(parentWidth, 600));
                else
                    window.setTimeout(ScaleSlider, 30);
            }
            ScaleSlider();

            $(window).bind("load", ScaleSlider);
            $(window).bind("resize", ScaleSlider);
            $(window).bind("orientationchange", ScaleSlider);
            //responsive code end
        });
    </script>
    <!-- Jssor Slider Begin -->
    <!-- To move inline styles to css file/block, please specify a class name for each element. --> 
    <div id="slider1_container" style="position: relative; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden; ">

        <!-- Loading Screen -->
        <div u="loading" style="position: absolute; top: 0px; left: 0px;">
            <div style="filter: alpha(opacity=70); opacity:0.7; position: absolute; display: block;
                background-color: #000000; top: 0px; left: 0px;width: 100%;height:100%;">
            </div>
            <div style="position: absolute; display: block; background: url(../img/loading.gif) no-repeat center center;
                top: 0px; left: 0px;width: 100%;height:100%;">
            </div>
        </div>

        <!-- Slides Container -->
        <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 600px; height: 300px; overflow: hidden;">
            <div>
                <img u="image" src='static/img/01.jpg' />
            </div>
            <div>
                <img u="image" src='static/img/02.jpg' />
            </div>
            <div>
                <img u="image" src="static/img/03.jpg" />
            </div>
            <div>
                <img u="image" src='static/img/04.png' />
            </div>
            <div>
                <img u="image" src="static/img/05.jpg" />
            </div>

        </div>
        
        <!--#region Bullet Navigator Skin Begin -->
        <!-- Help: http://www.jssor.com/development/slider-with-bullet-navigator-jquery.html -->
        <style>
            /* jssor slider bullet navigator skin 05 css */
            /*
            .jssorb05 div           (normal)
            .jssorb05 div:hover     (normal mouseover)
            .jssorb05 .av           (active)
            .jssorb05 .av:hover     (active mouseover)
            .jssorb05 .dn           (mousedown)
            */
            .jssorb05 {
                position: absolute;
            }
            .jssorb05 div, .jssorb05 div:hover, .jssorb05 .av {
                position: absolute;
                /* size of bullet elment */
                width: 16px;
                height: 16px;
                background: url(../img/b05.png) no-repeat;
                overflow: hidden;
                cursor: pointer;
            }
            .jssorb05 div { background-position: -7px -7px; }
            .jssorb05 div:hover, .jssorb05 .av:hover { background-position: -37px -7px; }
            .jssorb05 .av { background-position: -67px -7px; }
            .jssorb05 .dn, .jssorb05 .dn:hover { background-position: -97px -7px; }
        </style>
        <!-- bullet navigator container -->
        <div u="navigator" class="jssorb05" style="bottom: 16px; right: 6px;">
            <!-- bullet navigator item prototype -->
            <div u="prototype"></div>
        </div>
        <!--#endregion Bullet Navigator Skin End -->
        
        <!--#region Arrow Navigator Skin Begin -->
        <!-- Help: http://www.jssor.com/development/slider-with-arrow-navigator-jquery.html -->
        <style>
            /* jssor slider arrow navigator skin 12 css */
            /*
            .jssora12l                  (normal)
            .jssora12r                  (normal)
            .jssora12l:hover            (normal mouseover)
            .jssora12r:hover            (normal mouseover)
            .jssora12l.jssora12ldn      (mousedown)
            .jssora12r.jssora12rdn      (mousedown)
            */
            .jssora12l, .jssora12r {
                display: block;
                position: absolute;
                /* size of arrow element */
                width: 30px;
                height: 46px;
                cursor: pointer;
                background: url(../img/a12.png) no-repeat;
                overflow: hidden;
            }
            .jssora12l { background-position: -16px -37px; }
            .jssora12r { background-position: -75px -37px; }
            .jssora12l:hover { background-position: -136px -37px; }
            .jssora12r:hover { background-position: -195px -37px; }
            .jssora12l.jssora12ldn { background-position: -256px -37px; }
            .jssora12r.jssora12rdn { background-position: -315px -37px; }
        </style>
        <!-- Arrow Left -->
        <span u="arrowleft" class="jssora12l" style="top: 123px; left: 0px;">
        </span>
        <!-- Arrow Right -->
        <span u="arrowright" class="jssora12r" style="top: 123px; right: 0px;">
        </span>
        <!--#endregion Arrow Navigator Skin End -->
        <a style="display: none" href="http://www.jssor.com">Bootstrap Slider</a>
    </div>
    <!-- Jssor Slider End -->

	
	
	<!--  
		<FORM method="POST" action=" /Lecoib/MostrarEmpleadoJSP ">
			B�squeda de clientes<BR><BR>
			<TABLE border="0">
				<TR>
					<TD>DNI:</TD>
					<TD><INPUT name="dni"></TD>
				</TR>
				<TR>
					<TD>
						<INPUT type="submit" value="Consultar">
					</TD>
				</TR>
			</TABLE>
		</FORM>
		-->
	<%@ include file="/jsp/pie.jsp" %>
</body>
</html>