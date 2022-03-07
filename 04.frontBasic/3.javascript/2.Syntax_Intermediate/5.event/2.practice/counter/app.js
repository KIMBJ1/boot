
const number = document.getElementById("number");
const increase = document.getElementById("increase");
const decrease = document.getElementById("decrease");

console.log(number);
console.log(increase);
console.log(decrease);

increase.onclick = () => {
    const result =  parseInt(number.innerText);
    console.log(typeof result);
    // const result =  number.innerText;
    number.textContent = result + 1;
}

decrease.addEventListener('click', () => {
    const result = parseInt(number.innerText);
    console.log(typeof result);
    number.textContent = result - 1;
});


reset.onclick = () => {
    number.textContent = 0
    console.log(typeof result);
}