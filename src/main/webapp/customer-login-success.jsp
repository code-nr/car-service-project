<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome - Car Service System</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap">
  <style>
    /* Global Styling */
    body {
      margin: 0;
      font-family: 'Poppins', sans-serif;
      background: linear-gradient(135deg, #003973, #E5E5BE);
      background-size: 400% 400%;
      animation: gradientBackground 8s ease infinite;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      color: #fff;
    }

    @keyframes gradientBackground {
      0% { background-position: 0% 50%; }
      50% { background-position: 100% 50%; }
      100% { background-position: 0% 50%; }
    }

    /* Container Styling */
    .container {
      background: rgba(255, 255, 255, 0.9);
      padding: 30px 25px;
      border-radius: 10px;
      box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
      width: 100%;
      max-width: 600px;
      text-align: center;
    }

    h1 {
      font-size: 1.8em;
      margin-bottom: 20px;
      color: #003973;
    }

    .message {
      font-size: 1.2em;
      color: #555;
      margin-bottom: 30px;
    }

    .links {
      display: flex;
      flex-direction: column;
      gap: 15px;
    }

    .links a {
      text-decoration: none;
      font-size: 16px;
      color: #fff;
      background: linear-gradient(135deg, #11998e, #38ef7d);
      padding: 12px 20px;
      border-radius: 5px;
      text-align: center;
      transition: transform 0.3s, box-shadow 0.3s;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
    }

    .links a:hover {
      transform: translateY(-5px);
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.4);
    }

    /* Responsive Design */
    @media (max-width: 480px) {
      h1 {
        font-size: 1.6em;
      }

      .message {
        font-size: 1em;
      }

      .links a {
        font-size: 14px;
        padding: 10px 15px;
      }
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Welcome</h1>
    <div class="message">
      <% 
        String name = (String) session.getAttribute("sname");
        out.println("Dear " + name + ", you have successfully logged in.");
      %>
    </div>
    <div class="links">
      <a href="/01-car-service-system/add-car-details.html">Add Car Details</a>
      <a href="/01-car-service-system/edit-car-details.html">Edit Car Details</a>
      <a href="/01-car-service-system/service-request.html">Service Request</a>
      <a href="/01-car-service-system/check-status.html">Check Service Status</a>
      <a href="/01-car-service-system/feedback.html">Feedback</a>
      <a href="/01-car-service-system/logout.html">Log Out</a>
    </div>
  </div>
</body>
</html>
