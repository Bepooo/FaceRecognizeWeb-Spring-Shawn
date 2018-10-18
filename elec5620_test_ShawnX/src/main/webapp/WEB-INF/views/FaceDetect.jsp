
<html>

<head>

<title>Document</title>
</head>

<body>
	<video id="video" autoplay="" style='width: 640px; height: 480px'></video>
	<button id="start">Invoke the Camera</button>
	<button id='picture'>Take a Photo</button>
	<button onclick="window.location.href='FaceDetectLogin'" type="button">Log in</button>
	<canvas id="canvas" width="640" height="480"></canvas>
</body>
<script type="text/javascript">
    var video = document.getElementById("video");
    var context = canvas.getContext("2d")
    var start = document.getElementById("start");
    var errocb = function () {
        console.log('ok!');
    }
    start.onclick = function () {
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

