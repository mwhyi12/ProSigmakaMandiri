<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Mahasiswa</title>
</head>
<body>
	<h2>Input Data Mahasiswa</h2>
	<form method="post" action="jdbcMaven">
		<table>
			<tr>
				<td>NIM :</td>
				<td><input type="text" name="nim_mhs" required></td>
			</tr>
			<tr>
				<td>Nama :</td>
				<td><input type="text" name="nama_mhs" required></td>
			</tr>
			<tr>
				<td>Domisili :</td>
				<td><input type="text" name="domisili_mhs" required></td>
			</tr>
			<tr>
				<td>
					<button type="submit">Submit</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>