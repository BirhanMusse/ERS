let user = {};
//IT WORKEDf
window.onload = function() {
	document.getElementById("resolved").onclick= viewResolved;
	document.getElementById("pending").onclick= viewpending;
	document.getElementById("yourInfo").onclick= viewYourInfo;
	document.getElementById("seeAll").onclick= ViewAllEmployees;
	document.getElementById("Everypending").onclick= ViewAllRequests;
	
}

//ViewEmpInfo
function disable(){
    document.getElementsByClassName("vanish").innerHTML="";
}
function viewResolved(){
    console.log("view resolved request");

    fetch("http://localhost:8043/birhanproject1/ViewResolved").then(function(response){
     
        return response.json();
    }).then(function(data){
        
       user=data;
      

       displayresolvedRequests();
   
   });
} 
    function viewpending(){
        console.log("view pending request");

        fetch("http://localhost:8043/birhanproject1/viewpending").then(function(response){
         
            return response.json();
        }).then(function(data){
            
           user=data;
          

           displaypendingRequests();
       
       });
}
function viewYourInfo(){
	console.log("view your Info");

	fetch("http://localhost:8043/birhanproject1/ViewMyInfo").then(function(response){
		
	return response.json();
	}).then(function(data){
		
	   user=data;
	  

	   displayYourInfo();
   
   });
}

function UpdateYourUsername(){
	console.log("updateUsername");

	fetch("http://localhost:8043/birhanproject1/ViewMyInfo").then(function(response){
		
	return response.json();
	}).then(function(data){
		
	   user=data;
	  

   
   });
}
function ViewAllEmployees(){
	console.log("ViewAllEmployes");

	fetch("http://localhost:8043/birhanproject1/ViewAllEmployee").then(function(response){
		
	return response.json();
	}).then(function(data){
		
	   user=data;
	  
	displayAllInfo();
   
   });
}
function ViewAllRequests(){
console.log("ViewAllRequests");
fetch("http://localhost:8043/birhanproject1/ViewAllRequests").then(function(response){
		
	return response.json();
	}).then(function(data){
		console.log(data);
	   user=data;
	  
	displayAllRequests();
   
   });

}
 

function displayAllRequests(){
	let table=document.createElement("table");
	table.id="table";
	document.getElementById("Allpending").appendChild(table);

	for(let i=0;i<user.length;i++){

		let row=document.createElement("tr");
		row.id="row"+i;
		row.class=row;
		document.getElementById("table").appendChild(row);

		let rId=document.createElement("td");
		rId.className="rId"
		rId.innerHTML="    Request Id: " +user[i].reqId;
		document.getElementById("row"+i).appendChild(rId);
	
		let amt=document.createElement("td");
		amt.className=", amt"
		amt.innerText="    "+"Amount: "+user[i].amount;
		document.getElementById("row"+i).appendChild(amt);
		
		let thedate=document.createElement("td");
		thedate.className="date"
		thedate.innerText="    Date of purchase: "+user[i].month+"/"+user[i].day+"/"+user[i].year;
		document.getElementById("row"+i).appendChild(thedate);

	   let stat=document.createElement("td");
			stat.className="stat";
		   stat.innerText="     Status: "+user[i].status;
		   document.getElementById("row"+i).appendChild(stat);
		
		let empId = document.createElement("td");
			empId.className="eid";
			empId.innerText="      Employee id: "+user[i].empId;
			document.getElementById("row"+i).appendChild(empId);
		
		let ans = document.createElement("td");
			ans.className="eid";
			ans.innerText="      Request Answer: "+user[i].reqAns;
			document.getElementById("row"+i).appendChild(ans);
//{"reqId":2061,"amount":100.0,"day":7,"month":11,"year":2019,"status":"PENDING","reqAns":"STILL PENDING","empId":2022}]
	}

}


function displayAllInfo(){
    let table=document.createElement("table");
    table.id="table1";
    document.getElementById("viewAll").appendChild(table);

    for(let i=0;i<user.length;i++){

        let row=document.createElement("tr");
        row.id="row"+i;
        row.class=row;
        document.getElementById("table1").appendChild(row);

        let eId=document.createElement("td");
        eId.className="rId"
        eId.innerHTML="   Your Employee Id: " +user[i].empId;
        document.getElementById("row"+i).appendChild(eId);
    
        let first=document.createElement("td");
        first.className="first"
        first.innerText="    First Name: "+user[i].firstname;
        document.getElementById("row"+i).appendChild(first);
        
        let last=document.createElement("td");
        last.className="last"
        last.innerText="     LastName: "+user[i].lastname;
        document.getElementById("row"+i).appendChild(last);

		let boss=document.createElement("td");
		boss.className="boss";
	 	boss.innerText="     Boss: "+user[i].repsTo;
		 document.getElementById("row"+i).appendChild(boss);
		 
		 let email=document.createElement("td");
		email.className="email";
	 	email.innerText="    Email Address: "+user[i].email+ "   ";
		 document.getElementById("row"+i).appendChild(email);
		 
		 let manager=document.createElement("td");
		manager.className="email";
	 	manager.innerText="    is a Manager (1= yes, 0=no): "+user[i].isMan;
	 	document.getElementById("row"+i).appendChild(manager);
	}
}

function displayYourInfo(){
    let table=document.createElement("table");
    table.id="table2";
    document.getElementById("viewInfo").appendChild(table);

    

        let row=document.createElement("tr");
        row.id="row";
        row.class=row;
        document.getElementById("table2").appendChild(row);

        let eId=document.createElement("td");
        eId.className="rId"
        eId.innerHTML="   Your Employee Id: " +user.empId;
        document.getElementById("row").appendChild(eId);
    
        let first=document.createElement("td");
        first.className="first"
        first.innerText="    First Name: "+user.firstname;
        document.getElementById("row").appendChild(first);
        
        let last=document.createElement("td");
        last.className="last"
        last.innerText="     LastName: "+user.lastname;
        document.getElementById("row").appendChild(last);

		let boss=document.createElement("td");
		boss.className="boss";
	 	boss.innerText="     Boss: "+user.repsTo;
		 document.getElementById("row").appendChild(boss);
		 
		 let email=document.createElement("td");
		email.className="email";
	 	email.innerText="    Username: "+user.email;
	 	document.getElementById("row").appendChild(email);

}
    
    
    
function displayresolvedRequests(){
    let table=document.createElement("table");
    table.id="table3";
    document.getElementById("viewResolved").appendChild(table);

    for(let i=0;i<user.length;i++){

        let row=document.createElement("tr");
        row.id="row"+i;
        row.class=row;
        document.getElementById("table3").appendChild(row);

        let rId=document.createElement("td");
        rId.className="rId"
        rId.innerHTML="    Request Id: " +user[i].reqId;
        document.getElementById("row"+i).appendChild(rId);
    
        let amt=document.createElement("td");
        amt.className=" amt"
        amt.innerText="    Amount: "+user[i].amount;
        document.getElementById("row"+i).appendChild(amt);
        
        let thedate=document.createElement("td");
        thedate.className="date"
        thedate.innerText="    Date of purchase: "+user[i].month+"/"+user[i].day+"/"+user[i].year;
        document.getElementById("row"+i).appendChild(thedate);

		let status=document.createElement("td");
		status.className="status";
	 status.innerText="    Status: "+user[i].status;
	 document.getElementById("row"+i).appendChild(status);

	}
}
	function displaypendingRequests(){
		let table=document.createElement("table");
		table.id="table4";
		document.getElementById("viewpending").appendChild(table);
	
		for(let i=0;i<user.length;i++){
	
			let row=document.createElement("tr");
			row.id="row"+i;
			row.class=row;
			document.getElementById("table4").appendChild(row);
	
			let rId=document.createElement("td");
			rId.className="rId"
			rId.innerHTML="    Request Id: " +user[i].reqId;
			document.getElementById("row"+i).appendChild(rId);
		
			let amt=document.createElement("td");
			amt.className=", amt"
			amt.innerText="    Amount: "+user[i].amount;
			document.getElementById("row"+i).appendChild(amt);
			
			let thedate=document.createElement("td");
			thedate.className="date"
			thedate.innerText="    Date of purchase: "+user[i].month+"/"+user[i].day+"/"+user[i].year;
			document.getElementById("row"+i).appendChild(thedate);
	
		   let status=document.createElement("td");
				  status.className="status";
			   status.innerText="     Status: "+user[i].status;
			   document.getElementById("row"+i).appendChild(status);
	
		}

}


