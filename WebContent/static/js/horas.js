$(document).ready(function () {
	// Get the context of the canvas element we want to select
	var ctx = document.getElementById("horasTrabajadas").getContext("2d");
	
	
	
	var data = {
		    labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
		    datasets: [
		        {
		            label: "Blanco",
		            fillColor: "rgba(220,220,220,0.2)",
		            strokeColor: "rgba(220,220,220,1)",
		            pointColor: "rgba(220,220,220,1)",
		            pointStrokeColor: "#fff",
		            pointHighlightFill: "#fff",
		            pointHighlightStroke: "rgba(220,220,220,1)",
		            data: [65, 59, 80, 81, 56, 55, 40, 30, 20, 90, 66, 42]
		        },
		        {
		            label: "Azul",
		            fillColor: "rgba(151,187,205,0.2)",
		            strokeColor: "rgba(151,187,205,1)",
		            pointColor: "rgba(151,187,205,1)",
		            pointStrokeColor: "#fff",
		            pointHighlightFill: "#fff",
		            pointHighlightStroke: "rgba(151,187,205,1)",
		            data:[]
		        },
		        {
		            label: "otro",
		            fillColor: "rgba(19,209,60,0.2)",
		            strokeColor: "rgba(19,209,60,1)",
		            pointColor: "rgba(19,209,60,1)",
		            pointStrokeColor: "#fff",
		            pointHighlightFill: "#fff",
		            pointHighlightStroke: "rgba(19,209,60,1)",
		            data: [50, 50, 50, 59, 56, 57, 50, 50, 54, 53, 50, 54]
		        
		        	
		        }
		    ]
		};
    for (i=0; i<data.labels.length; i++)
    {
    	data.datasets[1].data[i] = $("#balance"+i).text();
    }
    
	
	var myLineChart = new Chart(ctx).Line(data);
});


