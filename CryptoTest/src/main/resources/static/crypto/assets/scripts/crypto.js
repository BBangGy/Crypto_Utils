const $cryptoForm = document.getElementById('cryptoForm');
const $result = $cryptoForm.querySelector(":scope>.table>tbody>tr>td>.row>.result");
const warning = $cryptoForm.querySelector(":scope>.table>tbody>tr>td>.firstRow>.secondCol>.warning")
$cryptoForm.onsubmit = (e) => {
    e.preventDefault();
    const xhr = new XMLHttpRequest();
    const formData = new FormData();
    formData.append("option", $cryptoForm['option'].value);
    formData.append("inputText", $cryptoForm['inputText'].value);
    formData.append("toUpper", $cryptoForm['toUpper'].checked);
    xhr.onreadystatechange = () => {
        if (xhr.readyState !== XMLHttpRequest.DONE) {
            return;
        }
        if (xhr.status < 200 || xhr.status >= 300) {
            alert(`${xhr.status}오류`);
            return;
        }
        const response = JSON.parse(xhr.response);
        console.log(response['result'],response['status'])
        if (response['status'] === 'FAIL') {
            warning.classList.add('--visible');
            $result.innerText = '입력부탁드립니다.';
        } else {
            warning.classList.remove('--visible');
            $result.innerText = response['result'];
            $cryptoForm['toUpper'].checked = false;
        }

    }

    xhr.open("POST", location.href);
    xhr.send(formData);
}