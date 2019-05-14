<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Member Join</title>
</head>
<body>
	<div class="col-sm-3"></div>
	<div class="col-sm-9">
	<h2>Member Join</h2>
		<form action="${pageContext.request.contextPath}/member/join" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td></td>
					<td><input type="text" name="memberId"></td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td></td>
					<td><input type="password" name="memberPw"></td>
				</tr>
				<tr>
					<th>NAME</th>
					<td></td>
					<td><input type="text" name="memberName"></td>
				</tr>
				<tr>
					<th>PHONE</th>
					<td></td>
					<td><input type="text" name="memberPhone"></td>
				</tr>
				<tr>
					<th>ADDRESS</th>
					<td></td>
					<td><input type="text" name="memberAddress"></td>
				</tr>
				<tr>
					<th>GENDER</th>
					<td></td>
					<td>
					<div class="container mt-3">
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" value="F" id="F" name="memberGender">
							<label class="custom-control-label" for="F">F</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" value="M" id="M" name="memberGender">
							<label class="custom-control-label" for="M">M</label>
						</div>
					</div>
					</td>
				</tr>
				<tr>
					<th>LEVEL</th>
					<td></td>
					<td>
						<select name="memberLevel">
							<option value="customer">Customer</option>
    						<option value="employee">Employee</option>
						</select>
					</td>
				</tr>
				<tr>
				</tr>
				<tr>
					<th colspan="3">
						<button type="reset" class="btn btn-light">다시작성하기</button>
						<button type="submit" class="btn btn-success">Join</button>
					</th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>