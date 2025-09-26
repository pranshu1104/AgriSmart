// Register
document.getElementById('registerForm').addEventListener('submit', async (e) => {
  e.preventDefault();
  const res = await fetch('http://localhost:8080/auth/register', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      username: document.getElementById('regUsername').value,
      password: document.getElementById('regPassword').value
    })
  });
  const data = await res.text();
  document.getElementById('response').innerText = data;
});

// Login
document.getElementById('loginForm').addEventListener('submit', async (e) => {
  e.preventDefault();
  const res = await fetch('http://localhost:8080/auth/login', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      username: document.getElementById('loginUsername').value,
      password: document.getElementById('loginPassword').value
    })
  });
  const data = await res.text();
  document.getElementById('response').innerText = data;
});
