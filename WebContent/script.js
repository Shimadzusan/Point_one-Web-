
function press_button(){                                        //method post
    document.getElementById('main_button');
    var date_one = document.getElementById('date_one').value;
    console.log('date_one: ' + date_one);
    var date_two = document.getElementById('date_two').value;
    console.log('date_two: ' + date_two);
    var flag_today_data = document.getElementById('flag_today_data').checked;
    console.log('flag_today_data: ' + flag_today_data);
    
    console.log(".. from press_button");
    var web_text = document.getElementById('web_text_area').value;
    console.log(web_text);
    
    var xhr = new XMLHttpRequest();
    
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4) {
                var data = xhr.responseText;
                var Obj = JSON.parse(data);
                document.getElementById("monitor").firstChild.nodeValue = " date: " + Obj.date;
                var omega = document.getElementById("monitor");
                
                omega.innerHTML =   
                "<table style=\"border: 0px solid black; width: 30%\">" +
                "<tr><td>&nbsp date: " + Obj.date +
                "<br>&nbsp begin_cash: " +
                "<br>&nbsp end_cash: " +
                "<br>&nbsp total_value_of_deals: " +
                "<br>&nbsp result income: " +
                "<br>&nbsp result payment: " +
                "<p>&nbsp (+Plus+)<br>&nbsp online_income: from sber: " +
                "<br>&nbsp income from nicom: " +
                "<br>&nbsp income from pults: " +
                "<br>&nbsp фнд: " + 
                "<br>&nbsp копия: " + 
                "<br>&nbsp печать: " + 
                "<br>&nbsp other: " + 
                "<br>&nbsp total**: " +
                "<p>&nbsp (-Minus-)<br>&nbsp payment for nicom: " +
                "<br>&nbsp payment for pults: " +
                "<br>&nbsp payment for baget: " +
                "<br>&nbsp payment for fotolab: " +
                "<br>&nbsp other: " +
                "<br>&nbsp salary: " + Obj.salary +
                "</td>" + 
                
                "<td>" + 
                "<br>" + Obj.begin_cash + "<br>" + Obj.end_cash +
                "<br>&nbsp-//-" +
                "<br>" + Obj.income +
                "<br>" + Obj.payment +
                "<p>" + 
                "<br>" + Obj.sber +
                "<br>" + Obj.nicom +
                "<br>" + Obj.pults +
                "<br>" + Obj.foto +
                "<br>" + Obj.copy +
                "<br>" + Obj.print +
                "<br>" + (Obj.income - Obj.foto - Obj.copy - Obj.print - Obj.pults - Obj.nicom) +
                "<br>" + (Obj.income - Obj.pults - Obj.nicom) +
                "<p>" +
                "<br>-" + Obj.nicom_minus +
                "<br>-" + Obj.pults_minus +
                "<br>-" + Obj.baget_minus +
                "<br>-" + Obj.fotolab_minus +
                "<br>-" + (Obj.payment - Obj.pults_minus - Obj.nicom_minus - Obj.baget_minus - Obj.fotolab_minus) +
                "<br>&nbsp" + 
                "</td></tr></table>"
            }
        }
        xhr.open('POST', 'ServletHamma', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("facture=" + web_text + "&date_one=" + date_one + "&date_two="
        		+ date_two + "&flag_today_data=" + flag_today_data);
 
            }

/*some variant of output
  				omega.innerHTML = " &nbsp date: " + Obj.date + 
                "<table style=\"border: 1px solid black; width: 30%\">" +
                "<tr><td>&nbsp begin_cash: " +
                "<br>&nbsp end_cash: </td>" + 
                
                "<td>" + Obj.begin_cash + "<br>" + Obj.end_cash + "</td></tr></table>" + 
                //"<br>&nbsp end_cash: " + Obj.end_cash +
                "<br>&nbsp total_value_of_deals: ---" + 
                "<br>&nbsp result income: " + Obj.income +
                "<br>&nbsp result payment: " + Obj.payment +
                "<p>&nbsp (+Plus+)<br>&nbsp online_income: from sber: " + Obj.sber + "&nbsp from tinkoff: -//-" +
                "<br>&nbsp income from nicom: " + Obj.nicom +
                "<br>&nbsp income from pults: " + Obj.pults +
                "<br>&nbsp фнд: " + Obj.foto +
                "<br>&nbsp копия: " + Obj.copy +
                "<br>&nbsp печать: " + Obj.print +
                "<br>&nbsp other: " + (Obj.income - Obj.foto - Obj.copy - Obj.print - Obj.pults - Obj.nicom) +
                "<br>&nbsp total**: " + (Obj.income - Obj.pults - Obj.nicom) +
                "<p>&nbsp (-Minus-)<br>&nbsp payment for nicom: -" + Obj.nicom_minus +
                "<br>&nbsp payment for pults: -" + Obj.pults_minus +
                "<br>&nbsp payment for baget: -" + Obj.baget_minus +
                "<br>&nbsp payment for fotolab: -" + Obj.fotolab_minus +
                "<br>&nbsp other: -" + (Obj.payment - Obj.pults_minus - Obj.nicom_minus - Obj.baget_minus - Obj.fotolab_minus) +
                "<p>&nbsp salary: " + Obj.salary;           
 */