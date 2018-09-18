<html>
<style>
#text {display:none;color:red}
</style>
<body>
<h2>Welcome Buddy!</h2>

	<form action="LoginServlet" method="post">
	
	<table>
		<tr>
			<td>
				<label for="username"><b>Username </b></label>
			</td>
			<td>
				<select  name="username">
					<option value="Brijesh">Brijesh</option>
					<option value="Darshan">Darshan</option>
					<option value="Kavya">Kavya</option>
					<option value="Mahesh">Mahesh</option>
					<option value="Mona">Mona</option>
					<option value="Pratik">Pratik</option>
					<option value="Sushant">Sushant</option>
					<option value="Sweta">Sweta</option>
					<option value="Tulsi">Tulsi</option>
					<option value="Vidisha">Vidisha</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<label for="password"><b>Password</b></label>
			</td>
			<td>
				<input id="password" type="password" placeholder="Enter Password" name="password" required/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Login"  />
			</td>
			<td></td>
		</tr>
	</table>
	
				
	</form>

	<p id="text">Your Caps lock is ON! though <b>Password</b> is not case sensitive. :P </p>

	<script>
	var input = document.getElementById("password");
	var text = document.getElementById("text");
	input.addEventListener("keyup", function(event) {
	
	if (event.getModifierState("CapsLock")) {
	    text.style.display = "block";
	  } else {
	    text.style.display = "none"
	  }
	});
	</script>


</body>
</html>
<!--  meta http-equiv="Refresh" content="0; URL=/homepage" -->
