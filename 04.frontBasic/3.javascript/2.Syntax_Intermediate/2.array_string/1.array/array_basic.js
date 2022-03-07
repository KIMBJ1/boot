const arr = ['orange', 'orange', 'orange-cookie'];
console.log(typeof arr, arr);
console.log(`arr.length : ${arr.length}`);
console.table(arr)

// 요소의 조회(접근)
console.log(`${arr[0]}, ${arr[2]}`);

// 요소의 추가, 갱신
arr[5] = 'new-cookie'
console.table(arr)
console.log(arr);

//요소의 삭제
const numArr = ['orange', 'kiwi', 'apple'];
//희소 배열이 만들어짐
delete numArr[1];
console.table(numArr);
console.log(`numArr.length : ${numArr.length}`);

const nutArr = ['walnut', 'almond', 'pinenut'];
//삭제를 시작할 인덱스, 삭제할 요소 수
nutArr.splice(1,1);
console.log(nutArr);
console.log(`nutArr.length : ${nutArr.length}`);