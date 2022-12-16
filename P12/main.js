if (window.DeviceOrientationEvent) 
{ 
    window.addEventListener('deviceorientation', function (e) 
    { 
        a = Math.floor(e.alpha) 
        b = Math.floor(e.beta) 
        c = Math.floor(e.gamma) 
        el.style.transform = 'rotateZ('+a+'deg) rotateX('+b+'deg) rotateY('+c+'deg)'
    }, true)
}