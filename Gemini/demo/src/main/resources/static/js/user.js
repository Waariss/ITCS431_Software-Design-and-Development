function deleteUser(userId) {
    fetch(`/admin/users/${userId}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert('Error deleting user');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
document.querySelectorAll('.update-btn').forEach(button => {
    button.addEventListener('click', event => {
        const userId = event.target.getAttribute('data-id');
        document.getElementById('updateUserId').value = userId;

        const requestUrl = `/admin/users/${userId}`;
        console.log(`userId: ${userId}`);
        console.log(`Request URL: ${requestUrl}`);

        fetch(requestUrl)
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Error fetching user data');
                }
            })
            .then(user => {
                document.getElementById('updateUsername').value = user.username;
                document.getElementById('updatePassword').value = user.password;
                document.getElementById('updateEmail').value = user.email;
                document.getElementById('updateFirstName').value = user.firstName;
                document.getElementById('updateLastName').value = user.lastName;
                document.getElementById('updateRole').value = user.role;
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });
});
function updateUser() {
    const id = document.getElementById('updateUserId').value;
    const username = document.getElementById('updateUsername').value;
    const password = document.getElementById('updatePassword').value;
    const email = document.getElementById('updateEmail').value;
    const firstName = document.getElementById('updateFirstName').value;
    const lastName = document.getElementById('updateLastName').value;
    const role = document.getElementById('updateRole').value;

    fetch(`/admin/users/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            username,
            password,
            email,
            firstName,
            lastName,
            role,
        }),
    })
        .then(response => {
            if (response.ok) {
                location.reload();
            } else {
                throw new Error('Error updating user');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}


