const felhaszadatai = document.getElementById('user-data');
const form_inner = document.getElementById('forminner');
let loged_userdata = JSON.parse(localStorage.getItem("loged_userdata"));

document.addEventListener('DOMContentLoaded', function () {
    data_innerHtml();

    const felhasznalo_form = document.querySelector("form");

    felhasznalo_form.addEventListener("submit", function (event) {
        event.preventDefault();
        const userNameIn = document.getElementById("userName").value;
        const lastNameIn = document.getElementById("lastName").value;
        const firstNameIn = document.getElementById("firstName").value;
        const emailIn = document.getElementById("email").value;
        const pas = document.getElementById("pas").value;
        const pasAgain = document.getElementById("pasAgain").value;

        //felhasznalo jelszavának egyezésének figyelése
        if (pas !== pasAgain) {
            alert("A jelszavak nem egyeznek!");
        } else {
            // A gomb, amire kattintottál
            const clickedButton = event.submitter;
            if (clickedButton.id === "save") {
                // Mentési logika
                var myHeaders = new Headers();
                myHeaders.append("Content-Type", "application/json");
                var raw = JSON.stringify({
                    "felhasznaloNev": userNameIn,
                    "vezetekNev": lastNameIn,
                    "keresztNev": firstNameIn,
                    "jelszo": pas
                });

                var requestOptions = {
                    method: 'PUT',
                    headers: myHeaders,
                    body: raw,
                    redirect: 'follow'
                };

                fetch(`http://localhost:8080/CodeCraftersWebshop-1.0-SNAPSHOT/webresources/felhasznalo/${loged_userdata.id}`, requestOptions)
                    .then(response => response.text())
                    .then(result => console.log(result))
                    .catch(error => console.log('error', error));
                console.log("Felhasználó frissítve");
                alert("Felhasználó frissítve");

                let responseObject = {
                    "felhasznaloNev": userNameIn,
                    "email": loged_userdata.email,
                    "id": loged_userdata.id,
                    "vezetekNev": lastNameIn,
                    "keresztNev": firstNameIn,
                    "jelszo": pas
                }
                loged_userdata = localStorage.setItem("loged_userdata", JSON.stringify(responseObject));
                console.log(loged_userdata);
                //még a local storageba nincsen el mentve a változtatás


            } else if (clickedButton.id === "delete") {
                // Törlés logika
                var myHeaders = new Headers();
                myHeaders.append("Content-Type", "application/json");

                var raw = JSON.stringify({
                    "felhasznaloNev": userNameIn,
                    "vezetekNev": lastNameIn,
                    "keresztNev": firstNameIn,
                    "jelszo": pas
                });

                var requestOptions = {
                    method: 'DELETE',
                    headers: myHeaders,
                    body: raw,
                    redirect: 'follow'
                };

                fetch(`http://localhost:8080/CodeCraftersWebshop-1.0-SNAPSHOT/webresources/felhasznalo/${loged_userdata.id}`, requestOptions)
                    .then(response => response.text())
                    .then(result => console.log(result))
                    .catch(error => console.log('error', error));
                console.log("A felhasználó törölve!");
                localStorage.removeItem('loged_userdata');
                alert("A felhasználó törölve!");
            }
        }
    });
});



function data_innerHtml() {
    felhaszadatai.innerHTML +=
        `
    <div class="user-img">
                <img src="../img/user.png" alt="Profil-kep">
            </div>
            <div id="user-name">${loged_userdata.felhasznaloNev}</div>
            <div class="d-flex flex-row">
                <div id="lastName">${loged_userdata.vezetekNev}</div>
                <div id="fistName">${loged_userdata.keresztNev}</div>
            </div>
    `;

    form_inner.innerHTML += `
                <form>
                    <div class="mb-3">
                        <label for="userName" class="form-label">Felhasználónév</label>
                        <input type="text" class="form-control" id="userName" placeholder="${loged_userdata.felhasznaloNev}" required>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-6 mb-3">
                            <label for="lastName" class="form-label">Vezetéknév</label>
                            <input type="text" class="form-control" id="lastName" placeholder="${loged_userdata.vezetekNev}" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="firstName" class="form-label">Keresztnév</label>
                            <input type="text" class="form-control" id="firstName" placeholder="${loged_userdata.keresztNev}" required>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="text" class="form-control" id="email" placeholder="${loged_userdata.email}" disabled>
                    </div>
                    <div class="mb-3">
                        <label for="pas" class="form-label">Jelszó</label>
                        <input type="password" class="form-control" id="pas" required>
                    </div>
                    <div class="mb-3">
                        <label for="pasAgain" class="form-label">Jelszó Újra</label>
                        <input type="password" class="form-control" id="pasAgain" required>
                    </div>
                    <div class="user-btns">
                        <button class="btn btn-primary w-100 mt-3 mx-auto" id="save" type="submit">Mentés</button>
                        <button class="btn btn-danger w-100 mt-3 mx-auto" id="delete" type="submit">Törlés</button>
                    </div>
                </form>
                `;
};