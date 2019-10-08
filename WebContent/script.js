
var a = "hello India";
var int = 0;
function my_f(){
    document.getElementById('mybutton');
    alert(a);
    console.log("hello consol");
            }
function method_one(){
    
    document.getElementById('button');
    console.log("called method_one");
    
    var text1 = document.getElementById('myTextArea').value;
    console.log(parseInt(text1) + 100);
    var c = parseInt(text1);
    var obj = document.getElementById("image");
    var element = document.getElementById("image").hspace; 
    var element1 = document.getElementById("image").alt;
    obj.hspace = c+100;
//  element.setAttribute("hspace", 5); 
//console.log("i am c" + c);
    console.log(obj);
    int = c;
    if(int==0){
    obj.setAttribute('src', 'su28.jpg');
        
        var omega = document.getElementById("tab");
        console.log(omega);
    omega.innerHTML = '';
       }
    
    if(int==1){
    obj.setAttribute('src', 'su27.jpg');
    
    var omega = document.getElementById("tab");
        console.log(omega);
    omega.innerHTML = '<p>hear must be the table</p><p>hear must be the table</p>';
    
       }
    
}

function get_number(){


  var element = document.getElementById("image").ATTRIBUTE_NODE; 
//  element.setAttribute("hspace", 5); 
consol.log(element);
}