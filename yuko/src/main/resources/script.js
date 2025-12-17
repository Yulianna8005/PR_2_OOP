const API_URL = 'http://localhost:8080';
const API_ENDPOINT = '/api/catches'; // <-- ЗМІНЕНО: Новий ендпоінт
const messageDiv = document.getElementById('message');
const tableBody = document.getElementById('tableBody');

// Завантажити дані при старті
loadCatches(); // <-- ЗМІНЕНО: Перейменовано функцію

function showMessage(text, type) {
    messageDiv.textContent = text;
    messageDiv.className = `message ${type} show`;
    setTimeout(() => {
        messageDiv.className = 'message';
    }, 3000);
}

// <-- ЗМІНЕНО: Перейменовано функцію
async function loadCatches() {
    try {
        // <-- ЗМІНЕНО: Використання нового ендпоінту
        const response = await fetch(`${API_URL}${API_ENDPOINT}`, {
            method: 'GET',
            mode: 'cors'
        });

        if (response.ok) {
            const catches = await response.json(); // <-- ЗМІНЕНО: Змінна 'catches'
            updateTable(catches);
        } else {
            const errorText = await response.text();
            showMessage('Помилка завантаження даних: ' + errorText, 'error');
            // Змінено colspan на 5 (кількість стовпців)
            tableBody.innerHTML = '<tr><td colspan="5" class="empty-state">Помилка: ' + errorText + '</td></tr>';
        }
    } catch (error) {
        showMessage("Помилка з'єднання з сервером", 'error');
        // Змінено colspan на 5 (кількість стовпців)
        tableBody.innerHTML = '<tr><td colspan="5" class="empty-state">Помилка з\'єднання з сервером: ' + error.message + '</td></tr>';
    }
}

// <-- ЗМІНЕНО: Функція приймає 'catches'
function updateTable(catches) {
    if (catches.length === 0) {
        // Змінено colspan на 5
        tableBody.innerHTML = '<tr><td colspan="5" class="empty-state">Немає записів про вилов</td></tr>';
        return;
    }

    let rowsHtml = '';
    // <-- ЗМІНЕНО: Ітерація та використання нових полів даних
    catches.forEach((entry, index) => {
        rowsHtml += `
            <tr>
                <td>${index + 1}</td>
                <td>${entry.fisherman}</td>
                <td>${entry.fish}</td>
                <td>${entry.weight.toFixed(2)}</td>
                <td>${entry.caughtAt}</td>
            </tr>
        `;
    });

    tableBody.innerHTML = rowsHtml;
    showMessage(`Успішно завантажено ${catches.length} записів вилову`, 'success');
}