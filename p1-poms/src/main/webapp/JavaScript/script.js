function hello (greeting){
    console.log(greeting+"Accepted");
}
hello ("ak");
// global.hello("ak");
window.setInterval (function(){
    console.log("hello\n");
},1000);

var x =24;
var y=43;
console.log (typeof x);
console.log(typeof y);

var price= null;
console.log(typeof price ==null);
console.log(typeof price==="object");

function ak(){
    console.log(this);
}
ak();

list=[1,2,5,7,5,7,6]
const a = list.slice(1,3);

if(1){
    console.log(1==true);
}
if(-1){
    console.log(1==false);
}
console.log(new Boolean(false)==2);

if("Hello")
console.log('"Hello"==true:'+("Hello"===true));
