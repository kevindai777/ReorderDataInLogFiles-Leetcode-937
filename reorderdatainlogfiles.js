let logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]


//O(nlogn) solution that sorts the logs based on letters or digits first
//Then we sort the letter logs, and concat the finished product to 
//the digits log

let letters = []
let digits = []

for (let log of logs) {
    if (isFinite(log.split(' ')[1])) {
        digits.push(log)
    } else {
        letters.push(log)
    }
}

let sortedLetters = letters.sort((a,b) => {
    let aCut = a.slice(a.indexOf(' ') + 1)
    let bCut = b.slice(b.indexOf(' ') + 1)

    if (aCut == bCut) {
        return a > b ? 1 : -1
    } else {
        return aCut > bCut ? 1 : -1
    }
})

return sortedLetters.concat(digits)