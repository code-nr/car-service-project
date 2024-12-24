<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Dashboard</title>
<style>
  /* Base Styles */
  body {
    margin: 0;
    padding: 0;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(135deg, #6a11cb, #2575fc); /* Gradient background */
    color: #fff;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    text-align: center;
  }

  h1 {
    font-size: 2.5rem;
    margin-bottom: 30px;
    color: #ffffff;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
    animation: fadeInDown 1s ease-in-out;
  }

  .dashboard-links {
    display: flex;
    flex-direction: column;
    gap: 15px;
    width: 100%;
    max-width: 400px;
    padding: 0 20px;
  }

  a {
    display: block;
    text-decoration: none;
    font-size: 1.2rem;
    color: #fff;
    background-color: #007bff;
    padding: 12px 20px;
    border-radius: 8px;
    text-align: center;
    font-weight: bold;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
    transition: all 0.3s ease;
    animation: slideInUp 1.2s ease-in-out;
  }

  a:hover {
    background-color: #0056b3;
    transform: scale(1.05); /* Slight zoom */
    box-shadow: 0 6px 10px rgba(0, 0, 0, 0.3);
  }

  /* Animations */
  @keyframes fadeInDown {
    from {
      opacity: 0;
      transform: translateY(-20px);
    }
    to {
      opacity: 1;
      transform: translateY(0);
    }
  }

  @keyframes slideInUp {
    from {
      opacity: 0;
      transform: translateY(30px);
    }
    to {
      opacity: 1;
      transform: translateY(0);
    }
  }

  /* Responsive Design */
  @media (max-width: 480px) {
    h1 {
      font-size: 2rem;
    }

    a {
      font-size: 1rem;
      padding: 10px 15px;
    }
  }
</style>
</head>
<body>
  <h1>Login Success</h1>
  <div class="dashboard-links">
    <a href="ViewCustomers">View Customers</a>
    <a href="ManageCustomers">Manage Customers</a>
    <a href="ViewRequests">View Service Requests</a>
    <a href="/01-car-service-system/update-status.jsp">Update the Service Status</a>
    <a href="CheckFeedback">Check Feedback</a>
    <a href="admin-login.html">Log Out</a>
  </div>
</body>
</html>
