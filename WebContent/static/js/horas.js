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
		            data: []
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
		            data: []
		        
		        	
		        }
		    ]
		};
	
    for (i=0; i<data.labels.length; i++)
    {
    	data.datasets[0].data[i] = $("#promedio"+i).text();
    }
    for (i=0; i<data.labels.length; i++)
    {
    	data.datasets[1].data[i] = $("#balance"+i).text();
    }
    
    for (i=0; i<data.labels.length; i++)
    {
    	data.datasets[2].data[i] = $("#extras"+i).text();
    }
    
	
	var myLineChart = new Chart(ctx).Line(data);
});


