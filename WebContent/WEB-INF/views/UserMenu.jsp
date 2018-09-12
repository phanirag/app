<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.navbar {
    overflow: hidden;
    background-color: #333;
    font-family: Arial, Helvetica, sans-serif;
}

.navbar1 {
    overflow: hidden;
    background-color: #333;
    font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.navbar1 a {
    float: right;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
	float:left;
	overflow: hidden;
}

.dropdown1 {
	float:right;
	overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
    font-family: inherit;
    margin: 0;
}

.dropdown1 .dropbtn1 {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
    font-family: inherit;
    margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

.navbar1 a:hover, .dropdown1:hover .dropbtn1 {
    background-color: red;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content1 {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 225px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content1 a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}


.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown1:hover .dropdown-content1 {
    display: block;
}

.greentext{
	color:#5298F5;
}
</style>
</head>
<body>
<img src="../images/pot2.png" />
<div class="navbar">
  <a href="#">Home</a>

	<!-- Location Start Here -->
  <div class="dropdown">
    <button class="dropbtn">LOCATION 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="regLoc">REGISTER</a>
      <a href="viewAllLocs">VIEW ALL</a>
      <a href="showLocReports">REPORTS</a>
    </div>
  </div> 
  	<!-- LOCATION end HERE -->
  	
  	<!-- VENDOR START HERE -->
  	<div class="dropdown">
    <button class="dropbtn">VENDOR 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="regVen">REGISTER</a>
      <a href="viewAllVens">VIEW ALL</a>
      <a href="showVenReports">REPORTS</a>
    </div>
  </div>
  <!-- VENDOR END HERE -->
  
  <!-- CUSTOMER STARTS HERE -->
  <div class="dropdown">
    <button class="dropbtn">CUSTOMER 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="regCust">REGISTER</a>
      <a href="viewAllcust">VIEW ALL</a>
      <a href="showcustReports">REPORTS</a>
    </div>
	</div>
	<!-- CUSTOMER ENDS HERE -->

  <!-- ITEM STARTS HERE -->
  <div class="dropdown">
    <button class="dropbtn">ITEM 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="viewAllItem">VIEW ALL</a>
    </div>
	</div>
	<!-- ITEM ENDS HERE -->
	
	 <!-- ORDER STARTS HERE -->
  <div class="dropdown">
    <button class="dropbtn">ORDER
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="viewAllOrder">VIEW ALL</a>
    </div>
	</div>
	<!-- ORDER ENDS HERE -->
	
  <a href="showDocs">DOCUMENTS</a>
  
 <div class="dropdown1">
      <span class="greentext"><b>${userName}</b></span>
    <button class="dropbtn1">
   		 <img src="../images/smily.png" width="21" height="20">
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content1">
		<a href="LogoutUser">LOGOUT</a>      
    </div>
	</div>  		
 
  


</div>

