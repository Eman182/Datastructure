<template>
  <div id="app">
    <head>
      <title>Calculator</title>
    </head>
    <body>
      <div class="main">
        <div class="form">
          <input type="text" name="textview" class="textview" v-model="text1">
        </div>
        <div class="clearfix">
          <div class="col-3"><input type="button" value="%" class="button" v-on:click="ConcatForPercent();"></div>
          <div class="col-3"><input type="button" value="CE" class="button" v-on:click="Clearing();"></div>
          <div class="col-3"><input type="button" value="C" class="button" v-on:click="Clearing();"></div>
          <div class="col-3"><input type="button" value="&#9003;" class="button" v-on:click="ClearLast();"></div>
        </div>
        <div class="clearfix">
          <div class="col-3"><input type="button" value="1/x" class="button" v-on:click="ConcatForMultInverse();"></div>
          <div class="col-3"><input type="button" value="x&#x00B2;" class="button" v-on:click="ConcatForSquaring();"></div>
          <div class="col-3"><input type="button" value="&#x221A;" class="button" v-on:click="ConcatForSquareRoot();"></div>
          <div class="col-3"><input type="button" value="&#xf7;" class="button" v-on:click="insert('/');" ></div>
        </div>
        <div class="clearfix">
          <div class="col-3"><input type="button" value="7" class="button" v-on:click="insert('7');"></div>
          <div class="col-3"><input type="button" value="8" class="button" v-on:click="insert('8');"></div>
          <div class="col-3"><input type="button" value="9" class="button" v-on:click="insert('9');"></div>
          <div class="col-3"><input type="button" value="&#xd7;" class="button" v-on:click="insert('*')"></div>
        </div>
        <div class="clearfix">
          <div class="col-3"><input type="button" value="4" class="button" v-on:click="insert('4');"></div>
          <div class="col-3"><input type="button" value="5" class="button" v-on:click="insert('5');"></div>
          <div class="col-3"><input type="button" value="6" class="button" v-on:click="insert('6');"></div>
          <div class="col-3"><input type="button" value="-" class="button" v-on:click="insert('-');"></div>
        </div>
        <div class="clearfix">
          <div class="col-3"><input type="button" value="1" class="button" v-on:click ="insert('1');"></div>
          <div class="col-3"><input type="button" value="2" class="button" v-on:click ="insert('2');"></div>
          <div class="col-3"><input type="button" value="3" class="button" v-on:click="insert('3');"></div>
          <div class="col-3"><input type="button" value="+" class="button" v-on:click="insert('+');"></div>
        </div>
        <div class="clearfix">
          <div class="col-3"><input type="button" value="+/-" class="button" v-on:click="Negation();"></div>
          <div class="col-3"><input type="button" value="0" class="button" v-on:click="insert('0');"></div>
          <div class="col-3"><input type="button" value="." class="button" v-on:click="insert('.');"></div>
          <div class="col-3"><input type="button" value="=" class="button" v-on:click ="calc();"></div>
        </div>
      </div>
    </body>
  </div>

</template>

<style >
  #app{
    margin : 0;
    padding : 0;
    box-sizing: border-box;
  }
    body{
      background: #333 ; 
    }
    .main{
      background: yellow;
      text-align: center;
      width: 400px;
      margin: 80px auto;
      padding: 20px;
    }
    .textview{
      width: 100%;font-size: 20px;
			height: 40px;margin: -10px;
			padding:0 5px;
			pointer-events: none;
    }
    .clearfix:before,.clearfix:after{
      content: ' ';margin :3px;
      display: table;
       clear:both; 
      width: 100%;
    }
    .col-3{
      width: 20%;padding: 5px;
      float: left;margin: 5px
    }
    .button{
      width: 100%;font-size: 22px;
      height: 40px;padding: 0 10px;
      outline: none;background: red;
      size: 500px
    }
</style>
<script>
import axios from 'axios'
export default {
  el: '#app',
  data:function() {
    return {
    text1 : ''
    };
  },
  methods :{
   insert : function(num) {
     var str=String(this.text1);
    var lastChar=str.charAt(str.length-1);
    if(str.length < 35){
      if(lastChar==null||(num>='0'&&num<='9')||num=='.'||(num!=lastChar&&(lastChar>='0'&&lastChar<='9'))
      ||(lastChar==')')){
        str=str.concat(num);this.text1=str;
      }
      else if(!(num>='0'&&num<='9')&&num!=lastChar&&!(lastChar>='0'&&lastChar<='9')){
        var str1=str.substring(0,str.length-1);
        if(lastChar!='.'){
        this.text1=str1.concat(num);
        }else{
          this.text1=String(this.text1).concat(num);
        }
      }else{
        this.text1=this.text1+"";
      }
    }
  },
   ConcatForPercent :function(){
    if( String(this.text1).length<32){
      this.text1='('+String(this.text1).concat("/100")+')';
    }
  },
   Negation:function(){
    if( String(this.text1).length<31){
      this.text1='('+String(this.text1).concat("*-1")+')';
    }
  },
   ConcatForSquareRoot:function(){
    if( String(this.text1).length<34){
      this.text1='('+String(this.text1).concat("^0.5)");
    }
  },
   ConcatForMultInverse:function(){
    if( String(this.text1).length<35){
      this.text1='('+String(this.text1).concat("^-1)");
    }
  },
   ConcatForSquaring :function(){
    if(String(this.text1).length<35){
      this.text1='('+String(this.text1).concat("^2)");
    }
  },
  Clearing :function(){
    this.text1="";
  },
  ClearLast:function(){
    if(String(this.text1).length>='1'){
    this.text1=String(this.text1).substring(0,String(this.text1).length-1);
    }//else we willnot delete as the string is empty
  },
  calc : function(){//get the result
      var st=this.text1;
       axios.get("http://localhost:8088/evaluate",{
       params : {
         expression : String(st),
       }
     })
     .then(response=>{
       console.log("The result is "+response.data);
       if(String(response.data).length<35){
       this.text1=response.data;
       }else{
         if(String(response.data).contains(".")==false){
         var x=String(response.data).length-1;
         this.text1=String(response.data).charAt(0)+"."+String(response.data).substring(1,28)+"*"+"10^"+x;
         //the length of result shouldn't be greater than display screen
         }else{
             //we take substring directly
             this.text1=String(response.data).substring(0,33)+"E";
         }
       }
     })
  },
  },
}
</script>


