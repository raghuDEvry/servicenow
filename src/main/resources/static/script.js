document.getElementById('callMeForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const phone = document.getElementById('phone').value;

    fetch('/api/call-me', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name: name, phone: phone })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('callMeResponse').innerText = data.message;
    });
});

document.getElementById('contactForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const message = document.getElementById('message').value;

    fetch('/api/contact', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email: email, message: message })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('contactResponse').innerText = data.message;
    });
});
