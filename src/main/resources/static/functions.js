function send_lottery_info() {
   // Sending and receiving data in JSON format using POST method
   var xhr = new XMLHttpRequest();

   domain="http://localhost:8080/";
   var url = domain+geturl();

   var method=getmethod();

   xhr.open(method, url, true);
   xhr.setRequestHeader("Content-Type", "application/json");

   xhr.upload.onerror = function() {
      alert("There was an upload error of some sort");
   };

   xhr.onerror = function() {
      alert("There was a connection error of some sort");
   };

   xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
          //alert("onreadystatechange success");
          var json = JSON.parse(xhr.responseText);

          message=createmessage(json);
          alert(message);

       }
   };


   var data = makedata();
   xhr.send(data);


   // alert("The data was sent");
   alert('The data was sent to the server url: "'+url+'"');

};
