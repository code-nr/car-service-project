<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Status</title>
<style>
  /* Base Styles */
  body {
    margin: 0;
    padding: 0;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(135deg, #6a11cb, #2575fc); /* Gradient background */
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    color: #fff;
  }

  .form-container {
    background: #fff;
    color: #333;
    padding: 30px 20px;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
    width: 90%;
    max-width: 400px;
    box-sizing: border-box;
  }

  h1 {
    font-size: 1.8rem;
    margin-bottom: 20px;
    text-align: center;
    color: #007bff;
  }

  table {
    width: 100%;
    border-collapse: collapse;
  }

  td {
    padding: 10px 5px;
    font-size: 1rem;
  }

  td:first-child {
    text-align: right;
    font-weight: bold;
    padding-right: 10px;
  }

  input[type="text"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 1rem;
    box-sizing: border-box;
    outline: none;
    transition: border-color 0.3s ease;
  }

  input[type="text"]:focus {
    border-color: #007bff;
  }

  input[type="submit"] {
    width: 100%;
    padding: 12px;
    font-size: 1.2rem;
    font-weight: bold;
    color: #fff;
    background-color: #007bff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background 0.3s ease;
    margin-top: 10px;
  }

  input[type="submit"]:hover {
    background-color: #0056b3;
  }

  /* Responsive Design */
  @media (max-width: 480px) {
    td:first-child {
      text-align: left;
      padding-right: 0;
      display: block;
      margin-bottom: 5px;
    }

    td {
      display: block;
      width: 100%;
    }

    input[type="submit"] {
      margin-top: 15px;
    }

    h1 {
      font-size: 1.5rem;
    }
  }
</style>
</head>
<body>
  <div class="form-container">
    <h1>Update Status</h1>
    <form action="UpdateStatus">
      <table>
        <tr>
          <td>User Name</td>
          <td><input type="text" name="username" placeholder="Enter user name" required></td>
        </tr>
        <tr>
          <td>Car Registration Number</td>
          <td><input type="text" name="carRegistrationNumber" placeholder="Enter car registration number" required></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="Update Status"></td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
