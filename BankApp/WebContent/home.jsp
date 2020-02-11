<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #F13241;
  padding: 20px;
  text-align: center;
  font-size: 25px;
  color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 30%;
  height: 400px; /* only for demonstration, should be removed */
  background: #F9E77E;
  padding: 20px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

article {
  float: left;
  padding: 20px;
  width: 70%;
  background-color: #f1f1f1;
  height: 400px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: #47EEC0;
  padding: 6px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}
</style>
</head>
<body>
<header>
  <h2>SWISS BANK</h2>
</header>

<section>
  <nav>
    <ul>
    <h2>Welcome.. </h2>
    <h3>Bank Account Details, </h3>
    <li><a href="CheckBalance"><h3> > Check Balance </a></li>
    <li><a href="transfer.jsp"><h3> > Transfer Amount </a></li>
    <li><a href="loan.html"><h3> > Apply Loan </a></li>
    <li><a href="GetStatement"><h3> > Get Statement </a></li>
    <li> <a href="changePwd.jsp"><h3> > Change Password </a></li>
    <li><a href="Logout"><h3> > Logout</h2> </a></li>
    </ul>
  </nav>
  
  <article>
    <h1>Details</h1>
    <p>Swiss Bank Corporation was a Swiss investment bank and financial services company located in Switzerland. Prior to its merger, the bank was the third largest in Switzerland with over CHF300 billion of assets and CHF11.7 billion of equity.</p>
    <p>Throughout the 1990s, SBC engaged in a large growth initiative, shifting its focus from traditional commercial banking into investment banking, in an effort to match its larger Swiss rival Credit Suisse. As part of this strategy, SBC acquired US-based investment bank Dillon Read & Co. as well as London-based merchant bank S.G. Warburg in the mid-1990s. SBC also acquired Chicago-based Brinson Partners and O'Connor & Associates. These acquisitions formed the basis for a global investment banking business.</p>
  </article>
</section>

<footer>
  <p>Swiss Bank Corporation</p>
</footer>
</body>
</html>
