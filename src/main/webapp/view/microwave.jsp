<!DOCTYPE html>
<html>

<head>
	<title>Microwave</title
</head>

<body>

	<p>${message}</p>
	
	<br>
	<br>
	<!-- Set time -->
	<form action="/microwave/setTime" method="get">
		<input type="submit" value="Set time">   <input type="text" id="time" name="time" min="1" pattern="[0-9]{1,3}" required> Seconds (1 - 999)<br> 
	</form>
	<br>
	
	<br>
	<input type="button" onclick="location.href='start';" value="START" />
	<br>
	<br>
	<input type="button" onclick="location.href='stop';" value="STOP" />
	<br>
	<br>
	<input type="button" onclick="location.href='pause';" value="PAUSE" />
	<br>
	<br>
	<input type="button" onclick="location.href='resume';" value="RESUME" />
	<br>
	<br>
	<input type="button" onclick="location.href='quickStart';" value="QUICKSTART" />
	<br>
	
	<br>
	<form method="get">
		<input type="submit" value="HEAT BREAD" formaction="/microwave/heatBread">
		<input type="submit" value="HEAT MEAT" formaction="/microwave/heatMeat">
		<input type="submit" value="HEAT VEG" formaction="/microwave/heatVeg">   
		<input type="number" id="weight" name="weight" min="0.1" max="5" step="0.1" required> Kg (0.1 - 5)<br> 
	</form>
	<br>
	
	<br>
	<input type="button" onclick="location.href='closeDoor';" value="CLOSE DOOR" />
	<br>
	<br>
	<input type="button" onclick="location.href='openDoor';" value="OPEN DOOR" />
	<br>
</body>

</html>
















