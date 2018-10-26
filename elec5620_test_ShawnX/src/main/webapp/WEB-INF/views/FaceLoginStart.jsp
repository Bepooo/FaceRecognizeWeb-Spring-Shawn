
<html>

<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>LoginHome</title>

</head>


<body background="https://images.pexels.com/photos/994523/pexels-photo-994523.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
<h2 class="text-white">Invoke the camera first, then take a picture and submit.</h2>
<h3 class="text-white">The image will be automatically deleted when you log out.</h3>
	<video id="video" autoplay="" style='width: 640px; height: 480px'></video>
	<button id="start" class="btn btn-secondary btn-lg font-weight-bold">Invoke the Camera</button>
	<button id='picture' class="btn btn-secondary btn-lg font-weight-bold">Take a Photo</button>
	<button onclick="window.location.href='FaceLogining'" id='login' type="button" class="btn btn-secondary btn-lg font-weight-bold">Login</button>
	<canvas id="canvas" width="640" height="480"></canvas>
	<button onclick="window.location.href='FaceHome'" type="button" class="btn btn-secondary btn-lg font-weight-bold">Back
			to the home page</button>
</body>
<script type="text/javascript">
    var video = document.getElementById("video");
    var context = canvas.getContext("2d")
    var start = document.getElementById("start");
    var errocb = function () {
        console.log('ok!');
    }
    fnName();
    function fnName(){
    	document.getElementById("picture").style.visibility = "hidden";
    	document.getElementById("login").style.visibility = "hidden";
    }
    start.onclick = function () {
    	document.getElementById("picture").style.visibility = "visible";
        if (navigator.mediaDevices.getUserMedia) { // 标准的API
            var p = navigator.mediaDevices.getUserMedia({
                video: true
            });
            p.then(function (mediaStream) {
                var video = document.querySelector('video');
                video.src = window.URL.createObjectURL(mediaStream);
                video.onloadedmetadata = function (e) {
                    // Do something with the video here.
                    video.play();
                };
            });
        } else if (navigator.mediaDevices.webkitGetUserMedia) { // WebKit 
            var p = navigator.mediaDevices.webkitGetUserMedia({
                video: true
            });
            p.then(function (mediaStream) {
                var video = document.querySelector('video');
                video.src = window.URL.createObjectURL(mediaStream);
                video.onloadedmetadata = function (e) {
                    // Do something with the video here.
                    video.play();
                };
            });
        }
        document.getElementById("picture").addEventListener("click", function () {
        	document.getElementById("login").style.visibility = "visible";
            context.drawImage(video, 0, 0, 640, 480);
/*             var imagestring=canvas.toDataURL("image/png",1.0);
            download(imagestring,"asd",image/png);
            document.getElementById("aaa").value = imagestring; */
            var imagee = canvas.toDataURL("image/png").replace("image/png", "image/octet-stream");  // here is the most important part because if you dont replace you will get a DOM 18 exception.
            /* document.write(canvas.toDataURL("image/png")); */
            window.location.href=imagee; 
        });

        
    }
</script>

</html>

