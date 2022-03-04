const countValue = document.querySelector('#value');
console.dir(countValue.textContent);
const countButtons = document.querySelectorAll('button');

console.log(countButtons);

// forEach()의 인자값으로 callback fn 지정.

let count = 0;

countButtons.forEach((button) => {
    button.addEventListener('click', (event) => {
        const curTarget = event.currentTarget;
        // console.dir(curTarget);

        const styles = curTarget.classList[1];
        console.log(styles);

        // if(styles === 'decrease') {
        //     --count;
        // } else {
        //     ++count;
        // }

        count = styles !== 'reset' ? (count = styles === 'decrease' ? --count : ++count) : 0;
        console.log(count);

        let countValueColor = '';
        // count의 값이 0이면 grey, 양수면 green, 음수면 red
        countValueColor = count !== 0 ? (countValueColor = count > 0 ? 'blue' : 'red') : 'green';
        console.log(countValueColor);

        countValue.textContent = count;
        countValue.style.color = countValueColor;
    });
});