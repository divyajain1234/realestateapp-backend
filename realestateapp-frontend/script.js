const API_BASE = "http://localhost:8080";

// ----- Load Projects -----
function loadProjects() {
    fetch(`${API_BASE}/api/projects`)
        .then(res => res.json())
        .then(projects => {
            const container = document.getElementById("projects-container");
            container.innerHTML = "";
            projects.forEach(p => {
                container.innerHTML += `
                    <div class="card">
                        <img src="${p.imageUrl || 'https://via.placeholder.com/300x150'}" alt="${p.name}">
                        <div class="card-body">
                            <h3>${p.name}</h3>
                            <p>${p.description}</p>
                            <button>Read More</button>
                        </div>
                    </div>
                `;
            });
        })
        .catch(err => console.error("Error loading projects", err));
}

// ----- Load Clients -----
function loadClients() {
    fetch(`${API_BASE}/api/clients`)
        .then(res => res.json())
        .then(clients => {
            const container = document.getElementById("clients-container");
            container.innerHTML = "";
            clients.forEach(c => {
                container.innerHTML += `
                    <div class="card">
                        <div class="card-body">
                            <p>${c.description}</p>
                            <h4>${c.name}</h4>
                            <small>${c.designation}</small>
                        </div>
                    </div>
                `;
            });
        })
        .catch(err => console.error("Error loading clients", err));
}

// ----- Contact form submit -----
function submitContact() {
    const body = {
        fullName: document.getElementById("contact-name").value,
        email: document.getElementById("contact-email").value,
        mobile: document.getElementById("contact-mobile").value,
        city: document.getElementById("contact-city").value
    };

    fetch(`${API_BASE}/api/contacts`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
    }).then(res => {
        if (res.ok) {
            alert("Contact form submitted!");
        } else {
            alert("Something went wrong.");
        }
    })
    .catch(err => console.error("Contact error", err));
}

// ----- Newsletter subscribe -----
function subscribe() {
    const email = document.getElementById("newsletter-email").value;
    const body = { email };

    fetch(`${API_BASE}/api/subscribers`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
    }).then(res => {
        if (res.ok) {
            alert("Subscribed successfully!");
        } else {
            alert("Subscribe failed.");
        }
    })
    .catch(err => console.error("Subscribe error", err));
}

// Page load par data fetch karo
window.addEventListener("DOMContentLoaded", () => {
    loadProjects();
    loadClients();
});
