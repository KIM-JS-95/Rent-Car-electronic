<!--<%@ page contentType="text/html; charset=UTF-8" %>-->
<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>-->
<!--<%@ taglib prefix="util" uri="/ELFunctions" %>-->

<!DOCTYPE html>
<!--=== Coding by CodingLab | www.codinglabweb.com === -->
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="/css/support/create.css">
    <link rel="stylesheet" type="text/css" href="/css/support/style.css">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

</head>

<body>
    <div class="container">
        <header>Registration</header>

        <form>
            <div class="form first">
                <div class="details personal">
                    <span class="title">Vehicle Info</span>

                    <div class="fields">
                        <div class="input-field">
                            <label>Vehicle Number</label>
                            <input type="text" placeholder="Enter your name" required>
                        </div>

                        <div class="input-field">
                            <label>Production date</label>
                            <input type="date" placeholder="Enter birth date" required>
                        </div>

                        <div class="input-field">
                            <label>Brand</label>
                            <input type="text" placeholder="Enter your email" required>
                        </div>

                        <div class="input-field">
                            <label>Model</label>
                            <input type="number" placeholder="Enter mobile number" required>
                        </div>

                    </div>

                </div>

                <div class="details ID">
                    <span class="title">Register Info</span>

                    <div class="fields" id="tblFruits">
                        <div class="input-field">
                            <label>DC 콤보</label>
                            <input type="checkbox" name="checkbox" class="cm-toggle" value="1">
                        </div>
                        
                        <div class="input-field">
                            <label>DC차 데모</label>
                            <input type="checkbox" name="checkbox" class="cm-toggle" value="2">
                        </div>

                        <div class="input-field">
                            <label>AC 3상</label>
                            <input type="checkbox" name="checkbox" class="cm-toggle" value="3">
                        </div>

                        <div class="input-field">
                            <label>완속</label>
                            <input type="checkbox" name="checkbox" class="cm-toggle" value="4">
                        </div>

                    </div>

                    <button class="nextBtn">
                        <span class="btnText">Next</span>
                        <i class="uil uil-navigator"></i>
                    </button>
                </div>
            </div>

            <div class="form second">
                <div class="details address">
                    <span class="title">Register Details</span>

                    <div class="fields">
                        <div class="input-field">
                            <label>branch</label>
                            <input type="text" placeholder="Permanent or Temporary" required>
                        </div>

                        <div class="input-field">
                            <label>Cheif</label>
                            <input type="text" placeholder="Enter nationality" required>
                        </div>

                        <div class="input-field">
                            <label>Branch Phone Number</label>
                            <input type="text" placeholder="Enter your state" required>
                        </div>

                        <div class="input-field">
                            <label>Address</label>
                            <input type="text" placeholder="Enter your district" required>
                        </div>
                    </div>
                </div>

                <div class="details family">
                    <span class="title">Family Details</span>

                

                    <div class="buttons">
                        <div class="backBtn">
                            <i class="uil uil-navigator"></i>
                            <span class="btnText">Back</span>
                        </div>

                        <button class="sumbit" onclick="GetSelected()">
                            <span class="btnText">Submit</span>
                            <i class="uil uil-navigator"></i>
                        </button>
                    </div>

                </div>
            </div>
        </form>
    </div>

    <script>
        const form = document.querySelector("form"),
            nextBtn = form.querySelector(".nextBtn"),
            backBtn = form.querySelector(".backBtn"),
            allInput = form.querySelectorAll(".first input");


        nextBtn.addEventListener("click", () => {
            allInput.forEach(input => {
                if (input.value != "") {
                    form.classList.add('secActive');
                } else {
                    form.classList.remove('secActive');
                }
            })
        })
        backBtn.addEventListener("click", () => form.classList.remove('secActive'));
    </script>

<script type="text/javascript">
    function GetSelected() {
        //Create an Array.
        var selected = new Array();
 
        //Reference the Table.
        var tblFruits = document.getElementById("tblFruits");
 
        //Reference all the CheckBoxes in Table.
        var chks = tblFruits.getElementsByTagName("INPUT");
 
        // Loop and push the checked CheckBox value in Array.
        for (var i = 0; i < chks.length; i++) {
            if (chks[i].checked) {
                selected.push(chks[i].value);
            }
        }
 
        //Display the selected CheckBox values.
        if (selected.length > 0) {
            alert("Selected values: " + selected.join(","));
        }
    };
</script>

</body>

</html>



