
function press_button(){                                        //method post
    document.getElementById('main_button');
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
                omega.innerHTML = " &nbsp date: " + Obj.date + "<br>&nbsp begin_cash: " + Obj.begin_cash + 
                "<br>&nbsp end_cash: " + Obj.end_cash +
                "<br>&nbsp total_value_of_deals: ---" + 
                "<br>&nbsp result income: " + Obj.income +
                "<br>&nbsp result payment: " + Obj.payment +
                "<p>&nbsp (+Plus+)<br>&nbsp online_income: " + Obj.sber +
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
                
    
            }
        }
        xhr.open('POST', 'Servlet_betta', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("name="+web_text);

            }