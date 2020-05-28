var flag = false;
function printInForm(number){
  if (number == "+" || number == "-" || number == "x" || number == "/") {
    document.getElementById('sign').innerHTML = number;
    flag = true;
    return;
  }
  if (flag == false) {
    document.getElementById('left-value').innerHTML += number;
  }else {
    document.getElementById('right-value').innerHTML += number;
  }
}

function clean(){
  document.getElementById('left-value').innerHTML = '';
  document.getElementById('right-value').innerHTML = '';
  document.getElementById('result').innerHTML = '';
  flag = false;
}

function calculateForm(){
  var left = parseFloat(document.getElementById('left-value').innerText);
  var right = parseFloat(document.getElementById('right-value').innerText);
  var sign = document.getElementById('sign').textContent;
  var resultValue;
  switch (sign) {
  case '+':
    resultValue = left + right;
    break;
  case '-':
    resultValue = left - right;
    break;
  case 'x':
    resultValue = left * right;
    break;
  case '/':
    resultValue = left / right;
    break;
}

document.getElementById('result').innerHTML = resultValue;
}
