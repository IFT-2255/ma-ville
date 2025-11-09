document.addEventListener("DOMContentLoaded", async () => {
    try {
        const response = await fetch("/api/accounts");
        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        const data = await response.json();
        console.log("Accounts JSON:", data);
        nom_banque = data.nom;
        const bankName = document.getElementById("nom_banque");
        bankName.innerHTML = nom_banque;

        accounts = data.accounts;
        const tbody = document.querySelector("table tbody");
        accounts.forEach(acc => {
            const row = document.createElement("tr");
            row.innerHTML = `
            <td>${acc.numCompte}</td>
            <td>${acc.solde}$</td>
            `;
            tbody.appendChild(row);
        });

    } catch (error) {
        console.error("Fetch error:", error);
    }
});

document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("myForm");

    form.addEventListener("submit", async (e) => {
        e.preventDefault(); // prevent page reload

        // gather form data
        const data = {
            compte1: document.getElementById("name").value,
            compte2: document.getElementById("email").value,
            montant: parseFloat(document.getElementById("amount").value)
        };
        console.log(data);
        try {
            const response = await fetch("/api/transactions", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(data)
            });

            if (!response.ok) throw new Error(`HTTP ${response.status}`);

            const result = await response.json();
            console.log("Transfer success:", result);
            alert("Transfer completed successfully!");
        } catch (err) {
            console.error("Error:", err);
            alert("Transfer failed.");
        }
    });
});