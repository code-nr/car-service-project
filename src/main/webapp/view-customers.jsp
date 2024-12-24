<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gqt.model.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
<style>
  /* Basic Styles */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f0f8ff; /* Light blue background */
    color: #333;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    min-height: 100vh;
  }

  h1 {
    font-size: 2.5rem;
    color: #007bff;
    text-align: center;
    margin-bottom: 20px;
    animation: fadeIn 1.5s ease-in-out;
  }

  .customer-container {
    width: 80%;
    max-width: 800px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    padding: 20px;
    animation: slideIn 1s ease-out;
  }

  .customer {
    padding: 10px;
    margin: 10px 0;
    border-bottom: 1px solid #ddd;
    transition: background-color 0.3s ease;
  }

  .customer:hover {
    background-color: #f9f9f9;
  }

  /* Animations */
  @keyframes fadeIn {
    from {
      opacity: 0;
    }
    to {
      opacity: 1;
    }
  }

  @keyframes slideIn {
    from {
      transform: translateY(20px);
      opacity: 0;
    }
    to {
      transform: translateY(0);
      opacity: 1;
    }
  }
</style>
</head>
<body>

<h1>Customer List</h1>
<div class="customer-container">
  <%
    List<Customer> customerList = (List) session.getAttribute("scustomerList");
    if (customerList != null && !customerList.isEmpty()) {
        for (Customer customer : customerList) {
  %>
          <div class="customer">
            <%= customer %>
          </div>
  <%
        }
    } else {
  %>
        <div class="customer">
          No customers found.
        </div>
  <%
    }
  %>
</div>

</body>
</html>
